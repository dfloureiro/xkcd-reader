package com.dfl.xkdc.comics

import android.accounts.NetworkErrorException
import com.dfl.xkdc.comics.uimodel.Comic
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.model.ComicResponse
import com.dfl.xkdc.network.XkcdServices
import com.dfl.xkdc.schedulers.RxSchedulers
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.anyInt
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicsPresenterTest {

    @Mock
    private lateinit var view: ComicsFragment
    @Mock
    private lateinit var mapper: ComicsMapper
    @Mock
    private lateinit var services: XkcdServices
    @Mock
    private lateinit var rxSchedulers: RxSchedulers
    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var cut: ComicsPresenter

    @Before
    fun setup() {
        given(rxSchedulers.io()).willReturn(Schedulers.trampoline())
        given(rxSchedulers.mainThread()).willReturn(Schedulers.trampoline())
        cut = ComicsPresenter(view, mapper, services, rxSchedulers, compositeDisposable)
    }

    @Test
    fun `given latest comic id is the default id when load comic then services get comic without id and view shows received comic`() {
        //given
        cut.latestComicId = -10
        val numId = 2000
        val comicResponse = mock(ComicResponse::class.java)

        given(comicResponse.num).willReturn(numId)
        given(services.getComic()).willReturn(Single.just(comicResponse))

        val comic = mock(Comic::class.java)
        given(mapper.convert(comicResponse)).willReturn(comic)

        //when
        cut.loadComic()

        //then
        verify(view).hideProgress()
        verify(view).show(comic)
        assertFalse(view.isLoading)
        assertEquals(cut.latestComicId, numId)
    }

    @Test
    fun `given latest comic id is the bigger then 1 when load comic then services get comic with id and view shows received comic`() {
        //given
        cut.latestComicId = 2004
        val expectedId = 2003

        val comicResponse = mock(ComicResponse::class.java)
        given(services.getComic(expectedId)).willReturn(Single.just(comicResponse))

        val comic = mock(Comic::class.java)
        given(mapper.convert(comicResponse)).willReturn(comic)

        //when
        cut.loadComic()

        //then
        verify(view).hideProgress()
        verify(view).show(comic)
        assertFalse(view.isLoading)
        assertEquals(cut.latestComicId, expectedId)
    }

    @Test
    fun `given latest comic id is 1 when load comic then never call services`() {
        //given
        cut.latestComicId = 1

        //when
        cut.loadComic()

        //then
        verify(services, never()).getComic()
        verify(services, never()).getComic(anyInt())
    }

    @Test
    fun `given latest comic id when load comic gives error then hides progress stops loading and sets id`() {
        //given
        cut.latestComicId = 2004
        val expectedId = 2003

        given(services.getComic(expectedId)).willReturn(Single.error(NetworkErrorException()))

        //when
        cut.loadComic()

        //then
        verify(view).hideProgress()
        assertFalse(view.isLoading)
        assertEquals(cut.latestComicId, expectedId)
    }

    @Test
    fun `given composite disposable when unsubscribe then dispose composite disposable`() {
        //given

        //when
        cut.unsubscribe()

        //then
        verify(compositeDisposable).dispose()
    }
}