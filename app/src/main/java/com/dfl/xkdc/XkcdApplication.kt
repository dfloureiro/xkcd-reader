package com.dfl.xkdc

import android.app.Application
import com.dfl.xkdc.di.injectors.InjectorImpl
import timber.log.Timber.DebugTree
import timber.log.Timber


open class XkcdApplication : Application() {

    open val injector = InjectorImpl()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        injector.inject(this)
    }
}
