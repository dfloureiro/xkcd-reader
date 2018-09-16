package com.dfl.xkdc.comics

import com.dfl.xkdc.comics.uimodel.Comic
import com.dfl.xkdc.schedulers.RxSchedulers
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicsPresenterTest {

    @Mock
    private lateinit var view: ComicsFragment
    @Mock
    private lateinit var interactor: ComicsInteractor
    @Mock
    private lateinit var rxSchedulers: RxSchedulers
    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var cut: ComicsPresenter

    @Before
    fun setup() {
        given(rxSchedulers.io()).willReturn(Schedulers.trampoline())
        given(rxSchedulers.mainThread()).willReturn(Schedulers.trampoline())
        cut = ComicsPresenter(view, interactor, rxSchedulers, compositeDisposable)
    }

    @Test
    fun `given latest comic id is the default when subscribe then load latest comic from network`() {
        //given
        cut.latestComicId = -10
        val comicId = 2000
        val comic = mock(Comic::class.java)
        given(comic.id).willReturn(comicId)
        given(interactor.getComicNetwork()).willReturn(Single.just(comic))
        given(interactor.insertComic(comic)).willReturn(Completable.complete())

        //when
        cut.subscribe()

        //then
        assertEquals(cut.latestComicId, comicId)
        assertFalse(view.isLoading)
        verify(interactor).insertComic(comic)
        verify(view).hideProgress()
        verify(view).show(comic)
    }

    @Test
    fun `given latest comic id is the default id when load comic then load latest comic from network`() {
        //given
        cut.latestComicId = -10
        val comicId = 2000
        val comic = mock(Comic::class.java)
        given(comic.id).willReturn(comicId)
        given(interactor.getComicNetwork()).willReturn(Single.just(comic))
        given(interactor.insertComic(comic)).willReturn(Completable.complete())

        //when
        cut.loadComic()

        //then
        assertEquals(cut.latestComicId, comicId)
        assertFalse(view.isLoading)
        verify(interactor).insertComic(comic)
        verify(view).hideProgress()
        verify(view).show(comic)
    }

    @Test
    fun `given latest comic id is not the default id and not in the repository when load comic then load comic from network`() {
        //given
        cut.latestComicId = 2001
        val expectedId = 2000
        val comic = mock(Comic::class.java)
        given(interactor.getComicNetwork(expectedId)).willReturn(Single.just(comic))
        given(interactor.insertComic(comic)).willReturn(Completable.complete())
        given(interactor.getComicRepository(expectedId)).willReturn(Single.error(Exception()))

        //when
        cut.loadComic()

        //then
        assertEquals(cut.latestComicId, expectedId)
        assertFalse(view.isLoading)
        verify(interactor).insertComic(comic)
        verify(view).hideProgress()
        verify(view).show(comic)
    }

    @Test
    fun `given latest comic id is not the default id and in the repository when load comic then load comic from database`() {
        //given
        cut.latestComicId = 2001
        val expectedId = 2000
        val comic = mock(Comic::class.java)
        given(interactor.getComicRepository(expectedId)).willReturn(Single.just(comic))

        //when
        cut.loadComic()

        //then
        assertEquals(cut.latestComicId, expectedId)
        assertFalse(view.isLoading)
        verify(view).show(comic)
    }

    @Test
    fun `given latest comic id is not the default id and not in the repository when load comic fails then load comic from network`() {
        //given
        cut.latestComicId = 2001
        val expectedId = 2000
        given(interactor.getComicNetwork(expectedId)).willReturn(Single.error(Exception()))
        given(interactor.getComicRepository(expectedId)).willReturn(Single.error(Exception()))

        //when
        cut.loadComic()

        //then
        assertEquals(cut.latestComicId, expectedId)
        assertFalse(view.isLoading)
        verify(view).hideProgress()
    }

    @Test
    fun `given id when fav comic then repository fav comic`() {
        //given
        val id = 10
        given(interactor.favComic(id)).willReturn(Completable.complete())

        //when
        cut.favComic(id)

        //then
        verify(interactor).favComic(id)
    }

    @Test
    fun `given id when unFav comic then repository unFav comic`() {
        //given
        val id = 10
        given(interactor.unFavComic(id)).willReturn(Completable.complete())

        //when
        cut.unFavComic(id)

        //then
        verify(interactor).unFavComic(id)
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