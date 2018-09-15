package com.dfl.xkdc.comics

import android.support.annotation.VisibleForTesting
import com.dfl.xkdc.comics.uimodel.Comic
import com.dfl.xkdc.schedulers.RxSchedulers
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class ComicsPresenter(private val view: ComicsFragment,
                      private val repository: ComicsRepository,
                      private val rxSchedulers: RxSchedulers,
                      private val compositeDisposable: CompositeDisposable) {

    private val defaultId = -10
    @VisibleForTesting
    var latestComicId: Int = defaultId

    fun subscribe() {
        loadComicFromNetwork()
    }

    fun loadComic() {
        if (latestComicId > 1) {
            latestComicId -= 1
            val disposable = repository.getComicDatabase(latestComicId)
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

    fun favComic(id: Int) {
        val disposable = repository.favComic(id)
                .subscribeOn(rxSchedulers.io())
                .subscribe()
        compositeDisposable.add(disposable)
    }

    fun unFavComic(id: Int) {
        val disposable = repository.unFavComic(id)
                .subscribeOn(rxSchedulers.io())
                .subscribe()
        compositeDisposable.add(disposable)
    }

    private fun loadComicFromNetwork() {
        val disposable = comicToLoadFromNetwork()
                .subscribeOn(rxSchedulers.io())
                .doOnSuccess { compositeDisposable.add(repository.insertComic(it).subscribe()) }
                .doFinally { view.isLoading = false }
                .observeOn(rxSchedulers.mainThread())
                .doOnSubscribe { view.showProgress() }
                .doOnSuccess { view.show(it) }
                .doFinally { view.hideProgress() }
                .subscribeBy(onError = { Timber.e(it) })
        compositeDisposable.add(disposable)
    }

    private fun comicToLoadFromNetwork(): Single<Comic> {
        return when (latestComicId) {
            defaultId -> repository.getComicNetwork().doOnSuccess { latestComicId = it.id }
            else -> {
                repository.getComicNetwork(latestComicId)
            }
        }
    }

    fun unsubscribe() {
        compositeDisposable.dispose()
    }
}
