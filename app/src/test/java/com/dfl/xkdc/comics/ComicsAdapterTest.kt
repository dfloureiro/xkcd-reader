package com.dfl.xkdc.comics

import com.dfl.xkdc.loader.ImageLoader
import com.dfl.xkdc.uimodel.Comic
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ComicsAdapterTest {

    @Mock
    private lateinit var imageLoader: ImageLoader
    @Mock
    private lateinit var list: ArrayList<Comic>
    @Mock
    private lateinit var presenter: ComicFavPresenter

    private lateinit var cut: ComicsAdapter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        cut = ComicsAdapter(list, imageLoader, presenter)
    }

    @Test
    fun `given comic when on bind view holder then holder sets params`() {
        //given
        val holder = mock(ComicViewHolder::class.java)
        val position = 0
        val comic = mock(Comic::class.java)
        val image = "url"
        val title = "title"
        val description = "description"
        val id = 1000
        val isFav = true
        given(comic.url).willReturn(image)
        given(comic.title).willReturn(title)
        given(comic.description).willReturn(description)
        given(comic.id).willReturn(id)
        given(comic.isFav).willReturn(isFav)
        given(list[position]).willReturn(comic)

        //when
        cut.onBindViewHolder(holder, position)

        //then
        verify(holder).setImage(image)
        verify(holder).setTitle(title)
        verify(holder).setDescription(description)
        verify(holder).setId(id)
        verify(holder).setFav(isFav)
    }

    @Test
    fun `given comic when add comic then notify new item inserted`() {
        //given
        val comic = mock(Comic::class.java)
        val spyCut = spy(cut)

        //when
        spyCut.add(comic)

        //then
        verify(list).add(comic)
        verify(spyCut).notifyItemInserted(anyInt())
    }

    @Test
    fun `given position when remove comic then notify item removed`() {
        //given
        val position = 1
        val spyCut = spy(cut)

        //when
        spyCut.remove(position)

        //then
        verify(list).removeAt(position)
        verify(spyCut).notifyItemRemoved(position)
    }
}