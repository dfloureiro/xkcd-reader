package com.dfl.xkdc.di.components

import com.dfl.xkdc.XkcdApplication
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.di.modules.NetworkModule
import com.dfl.xkdc.di.modules.XkcdModule
import com.dfl.xkdc.loaders.ImageLoader
import com.dfl.xkdc.network.XkcdServices
import com.dfl.xkdc.schedulers.RxSchedulers
import dagger.Component
import javax.inject.Singleton

@Component(modules = [XkcdModule::class, NetworkModule::class])
@Singleton
interface XkcdComponent {

    fun inject(application: XkcdApplication)

    fun xkcdServices(): XkcdServices

    fun imageLoader(): ImageLoader

    fun rxSchedulers(): RxSchedulers

    fun comicsMapper(): ComicsMapper
}