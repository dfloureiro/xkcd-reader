package com.dfl.xkdc.network

import com.dfl.xkdc.model.ComicResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * retrieves comics from network
 * https://xkcd.com/json.html
 */
interface XkcdServices {

    /**
     * get comic from id
     * @param id id of the comic to retrieve
     * @return single to retrieve comic
     */
    @GET("/{id}/info.0.json")
    fun getComic(@Path("id") id: Int): Single<ComicResponse>

    /**
     * get latest comic
     * @return single to retrieve comic
     */
    @GET("/info.0.json")
    fun getComic(): Single<ComicResponse>
}