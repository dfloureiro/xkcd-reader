package com.dfl.xkdc.comics

import com.dfl.xkdc.comics.uimodel.Comic
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.database.ComicsRepository
import com.dfl.xkdc.network.XkcdServices
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class ComicsInteractor(private val service: XkcdServices, private val database: ComicsRepository, private val mapper: ComicsMapper) {

    fun getComicNetwork(): Single<Comic> {
        return service.getComic()
                .map { mapper.convert(it) }
    }

    fun getComicNetwork(id: Int): Single<Comic> {
        return service.getComic(id)
                .map { mapper.convert(it) }
    }

    fun getComicRepository(id: Int): Single<Comic> {
        return database.getComic(id)
                .map { mapper.convert(it) }
    }

    fun insertComic(comic: Comic): Completable {
        return database.insert(mapper.convert(comic))
    }

    fun favComic(id: Int): Completable {
        return database.favComic(id)
    }

    fun unFavComic(id: Int): Completable {
        return database.unFavComic(id)
    }

    fun getFavourites(): Flowable<Comic> {
        return database.getFavourites()
                .flatMapIterable { it }
                .map { mapper.convert(it) }
    }
}