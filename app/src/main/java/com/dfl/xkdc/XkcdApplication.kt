package com.dfl.xkdc

import android.app.Application
import com.dfl.xkdc.di.injectors.InjectorImpl

open class XkcdApplication : Application() {

    open val injector = InjectorImpl()

    override fun onCreate() {
        super.onCreate()
        injector.inject(this)
    }
}
