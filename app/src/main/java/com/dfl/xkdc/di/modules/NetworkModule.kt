package com.dfl.xkdc.di.modules

import com.dfl.xkdc.network.XkcdServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private val baseUrl = "https://xkcd.com/json.html/"

    @Singleton
    @Provides
    fun provideXkcdServices(okHttpClient: OkHttpClient, callAdapterFactory: RxJava2CallAdapterFactory, moshiConverterFactory: MoshiConverterFactory): XkcdServices {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(moshiConverterFactory)
                .baseUrl(baseUrl)
                .build()
                .create(XkcdServices::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createAsync()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }
}