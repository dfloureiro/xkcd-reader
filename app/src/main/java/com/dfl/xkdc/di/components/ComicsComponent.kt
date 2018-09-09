package com.dfl.xkdc.di.components

import com.dfl.xkdc.comics.ComicsAdapter
import com.dfl.xkdc.comics.ComicsFragment
import com.dfl.xkdc.comics.ComicsPresenter
import com.dfl.xkdc.di.modules.ComicsModule
import com.dfl.xkdc.di.scopes.PerFragment
import dagger.Component

@Component(modules = [ComicsModule::class], dependencies = [XkcdComponent::class])
@PerFragment
interface ComicsComponent {

    fun inject(comicsFragment: ComicsFragment)

    fun present(): ComicsPresenter

    fun adapter(): ComicsAdapter
}