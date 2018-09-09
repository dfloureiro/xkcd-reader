package com.dfl.xkdc.network

import com.dfl.xkdc.model.ComicResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface XkcdServices {

    @GET("/{id}/info.0.json")
    fun getComic(@Path("id") id: Int): Single<ComicResponse>

    @GET("/info.0.json")
    fun getComic(): Single<ComicResponse>
}