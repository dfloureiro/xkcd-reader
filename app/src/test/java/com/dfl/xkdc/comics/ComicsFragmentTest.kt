package com.dfl.xkdc.comics

import android.support.annotation.IdRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.dfl.xkdc.R
import com.dfl.xkdc.RobolectricXkcdApplication
import com.dfl.xkdc.uimodel.Comic
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@RunWith(RobolectricTestRunner::class)
@Config(application = RobolectricXkcdApplication::class)
class ComicsFragmentTest {

    @Mock
    private lateinit var presenter: ComicsPresenter
    @Mock
    private lateinit var adapter: ComicsAdapter

    private lateinit var cut: ComicsFragment

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        cut = ComicsFragment.newInstance().also {
            it.presenter = presenter
            it.adapter = adapter
            SupportFragmentTestUtil.startVisibleFragment(it)
        }
    }

    @Test
    fun `todo`() {
        //given
        val recyclerView = getView<RecyclerView>(R.id.comicsRecyclerView)
        recyclerView.measure(0, 0)
        recyclerView.layout(0, 0, 100, 1000)

        //when
        (recyclerView.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(100, 5)
        recyclerView.scrollToPosition(100)
        recyclerView.scrollTo(0, 100)

        //then
        verify(presenter).loadComic()
    }

    @Test
    fun `given comic when show comic then adapter adds comic`() {
        //given
        val comic = mock(Comic::class.java)

        //when
        cut.show(comic)

        //then
        verify(adapter).add(comic)
    }

    @Test
    fun `given position when remove item then adapter removes item`() {
        //given
        val position = 1

        //when
        cut.remove(position)

        //then
        verify(adapter).remove(position)
    }

    private fun <T : View> getView(@IdRes id: Int): T {
        val view = cut.view!!.findViewById<T>(id)
        assertNotNull(view)
        return view
    }
}