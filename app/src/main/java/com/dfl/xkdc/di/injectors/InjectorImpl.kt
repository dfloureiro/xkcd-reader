package com.dfl.xkdc.di.injectors

import com.dfl.xkdc.XkcdApplication
import com.dfl.xkdc.comics.ComicsFragment
import com.dfl.xkdc.di.components.DaggerComicsComponent
import com.dfl.xkdc.di.components.DaggerXkcdComponent
import com.dfl.xkdc.di.components.XkcdComponent
import com.dfl.xkdc.di.modules.ComicsModule
import com.dfl.xkdc.di.modules.NetworkModule
import com.dfl.xkdc.di.modules.XkcdModule

class InjectorImpl : Injector {

    private lateinit var xkcdComponent: XkcdComponent

    override fun inject(application: XkcdApplication) {
        xkcdComponent = DaggerXkcdComponent.builder()
                .networkModule(NetworkModule())
                .xkcdModule(XkcdModule())
                .build()
        xkcdComponent.inject(application)
    }

    override fun inject(fragment: ComicsFragment) {
        DaggerComicsComponent.builder()
                .xkcdComponent(xkcdComponent)
                .comicsModule(ComicsModule(fragment))
                .build()
                .inject(fragment)
    }
}