package com.dfl.xkdc

import com.dfl.xkdc.di.injectors.InjectorImpl
import org.mockito.Mockito.mock

class RobolectricXkcdApplication : XkcdApplication() {

    override val injector: InjectorImpl = mock(InjectorImpl::class.java)
}