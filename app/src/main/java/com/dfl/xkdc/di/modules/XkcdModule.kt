package com.dfl.xkdc.di.modules

import com.dfl.xkdc.loaders.ImageLoader
import com.dfl.xkdc.schedulers.RxSchedulers
import com.dfl.xkdc.schedulers.RxSchedulersImpl
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class XkcdModule {

    @Provides
    @Singleton
    fun providesImageLoader(picasso: Picasso): ImageLoader {
        return ImageLoader(picasso)
    }

    @Provides
    @Singleton
    fun providesPicasso(): Picasso {
        return Picasso.get()
    }

    @Provides
    @Singleton
    fun providesRxSchedulers(): RxSchedulers {
        return RxSchedulersImpl()
    }
}