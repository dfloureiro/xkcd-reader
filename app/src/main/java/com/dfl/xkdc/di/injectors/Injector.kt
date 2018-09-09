package com.dfl.xkdc.di.injectors

import com.dfl.xkdc.XkcdApplication
import com.dfl.xkdc.comics.ComicsFragment

interface Injector {

    fun inject(application: XkcdApplication)

    fun inject(fragment: ComicsFragment)
}