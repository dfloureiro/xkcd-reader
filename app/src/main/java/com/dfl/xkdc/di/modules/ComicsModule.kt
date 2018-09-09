package com.dfl.xkdc.di.modules

import com.dfl.xkdc.comics.ComicsAdapter
import com.dfl.xkdc.comics.ComicsFragment
import com.dfl.xkdc.comics.ComicsPresenter
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.di.scopes.PerFragment
import com.dfl.xkdc.loaders.ImageLoader
import com.dfl.xkdc.network.XkcdServices
import com.dfl.xkdc.schedulers.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ComicsModule(private val comicsFragment: ComicsFragment) {

    @PerFragment
    @Provides
    fun providesComicsPresenter(comicsMapper: ComicsMapper,
                                services: XkcdServices,
                                rxSchedulers: RxSchedulers,
                                compositeDisposable: CompositeDisposable): ComicsPresenter {
        return ComicsPresenter(comicsFragment, comicsMapper, services, rxSchedulers, compositeDisposable)
    }

    @PerFragment
    @Provides
    fun providesComicsAdapter(imageLoader: ImageLoader): ComicsAdapter {
        return ComicsAdapter(arrayListOf(), imageLoader)
    }

    @PerFragment
    @Provides
    fun providesCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}