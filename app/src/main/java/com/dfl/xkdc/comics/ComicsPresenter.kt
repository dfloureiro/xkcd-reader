package com.dfl.xkdc.comics

import android.support.annotation.VisibleForTesting
import com.dfl.xkdc.interactor.ComicsInteractor
import com.dfl.xkdc.schedulers.RxSchedulers
import com.dfl.xkdc.uimodel.Comic
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

/**
 * Presenter that handles all interactions with comics
 * @param view fragment view
 * @param interactor interactor to interact with local repository and network
 * @param rxSchedulers schedulers to subscribe on
 * @param compositeDisposable add and dispose disposables
 */
class ComicsPresenter(private val view: ComicsFragment,
                      private val interactor: ComicsInteractor,
                      private val rxSchedulers: RxSchedulers,
                      private val compositeDisposable: CompositeDisposable) : ComicFavPresenter {

    private val defaultId = -10
    @VisibleForTesting
    var latestComicId: Int = defaultId

    /**
     * subscribe the presenter initial tasks
     */
    fun subscribe() {
        loadComicFromNetwork()
    }

    /**
     * loads comic to display
     * if no valid id present, loads latest from network
     * if valid id present, and in the comic repository, loads from repository
     * if valid id present, and not in the comic repository, loads from network
     */
    fun loadComic() {
        if (latestComicId > 1) {
            latestComicId -= 1
            val disposable = interactor.getComicRepository(latestComicId)
                    .subscribeOn(rxSchedulers.io())
                    .doOnError { Timber.d("Database can't find comic with id $latestComicId") }
                    .doOnSuccess { view.isLoading = false }
                    .observeOn(rxSchedulers.mainThread())
                    .doOnSuccess { view.show(it) }
                    .subscribeBy(onError = { loadComicFromNetwork() })
            compositeDisposable.add(disposable)
        } else if (latestComicId == defaultId) {
            loadComicFromNetwork()
        }
    }

    /**
     * set comic as fav
     * @param id id of the comic to fav
     */
    override fun favComic(id: Int) {
        val disposable = interactor.favComic(id)
                .subscribeOn(rxSchedulers.io())
                .subscribe()
        compositeDisposable.add(disposable)
    }

    /**
     * set comic as unFav
     * @param id id of the comic to unFav
     */
    override fun unFavComic(id: Int) {
        val disposable = interactor.unFavComic(id)
                .subscribeOn(rxSchedulers.io())
                .subscribe()
        compositeDisposable.add(disposable)
    }

    /**
     * load comic from network and saves it to the repository
     */
    private fun loadComicFromNetwork() {
        val disposable = comicToLoadFromNetwork()
                .subscribeOn(rxSchedulers.io())
                .doOnSuccess { compositeDisposable.add(interactor.insertComic(it).subscribe()) }
                .doFinally { view.isLoading = false }
                .observeOn(rxSchedulers.mainThread())
                .doOnSubscribe { view.showProgress() }
                .doOnSuccess { view.show(it) }
                .doFinally { view.hideProgress() }
                .subscribeBy(onError = { Timber.e(it) })
        compositeDisposable.add(disposable)
    }

    /**
     * checks what observable to load:
     * if no valid id loads load latest
     * if valid id load with id
     * @return observable to subscribe
     */
    private fun comicToLoadFromNetwork(): Single<Comic> {
        return when (latestComicId) {
            defaultId -> interactor.getComicNetwork().doOnSuccess { latestComicId = it.id }
            else -> {
                interactor.getComicNetwork(latestComicId)
            }
        }
    }

    /**
     * disposes all disposables
     */
    fun unsubscribe() {
        compositeDisposable.dispose()
    }
}
