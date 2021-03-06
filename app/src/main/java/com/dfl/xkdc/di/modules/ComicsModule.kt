package com.dfl.xkdc.di.modules

import com.dfl.xkdc.comics.ComicsAdapter
import com.dfl.xkdc.comics.ComicsFragment
import com.dfl.xkdc.comics.ComicsPresenter
import com.dfl.xkdc.di.scopes.PerFragment
import com.dfl.xkdc.interactor.ComicsInteractor
import com.dfl.xkdc.loader.ImageLoader
import com.dfl.xkdc.schedulers.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ComicsModule(private val comicsFragment: ComicsFragment) {

    @PerFragment
    @Provides
    fun providesComicsPresenter(interactor: ComicsInteractor,
                                rxSchedulers: RxSchedulers,
                                compositeDisposable: CompositeDisposable): ComicsPresenter {
        return ComicsPresenter(comicsFragment, interactor, rxSchedulers, compositeDisposable)
    }

    @PerFragment
    @Provides
    fun providesComicsAdapter(imageLoader: ImageLoader, presenter: ComicsPresenter): ComicsAdapter {
        return ComicsAdapter(arrayListOf(), imageLoader, presenter)
    }

    @PerFragment
    @Provides
    fun providesCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}