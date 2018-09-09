package com.dfl.xkdc.comics

import android.support.annotation.VisibleForTesting
import com.dfl.xkdc.schedulers.RxSchedulers
import com.dfl.xkdc.network.XkcdServices
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy

class ComicsPresenter(private val view: ComicsFragment,
                      private val mapper: ComicsMapper,
                      private val services: XkcdServices,
                      private val rxSchedulers: RxSchedulers,
                      private val compositeDisposable: CompositeDisposable) {

    private val defaultId = -10
    @VisibleForTesting
    var latestComicId: Int = defaultId

    fun subscribe() {
        loadComic()
    }

    fun loadComic() {
        if (latestComicId > 1 || latestComicId == defaultId) {
            val disposable = when (latestComicId) {
                defaultId ->
                    services.getComic().doOnSuccess { latestComicId = it.num }
                else -> {
                    latestComicId -= 1
                    services.getComic(latestComicId)
                }
            }
                    .subscribeOn(rxSchedulers.io())
                    .map { mapper.convert(it) }
                    .observeOn(rxSchedulers.mainThread())
                    .doOnSubscribe { view.showProgress() }
                    .doFinally { view.hideProgress() }
                    .doFinally { view.isLoading = false }
                    .subscribeBy(
                            onSuccess = { view.show(it) },
                            onError = {}
                    )
            compositeDisposable.add(disposable)
        }
    }

    fun unsubscribe() {
        compositeDisposable.dispose()
    }
}
