package com.dfl.xkdc.di.components

import com.dfl.xkdc.XkcdApplication
import com.dfl.xkdc.interactor.ComicsInteractor
import com.dfl.xkdc.di.modules.RepositoryModule
import com.dfl.xkdc.di.modules.XkcdModule
import com.dfl.xkdc.loader.ImageLoader
import com.dfl.xkdc.schedulers.RxSchedulers
import dagger.Component
import javax.inject.Singleton

@Component(modules = [XkcdModule::class, RepositoryModule::class])
@Singleton
interface XkcdComponent {

    fun inject(application: XkcdApplication)

    fun imageLoader(): ImageLoader

    fun rxSchedulers(): RxSchedulers

    fun comicsInteractor(): ComicsInteractor
}