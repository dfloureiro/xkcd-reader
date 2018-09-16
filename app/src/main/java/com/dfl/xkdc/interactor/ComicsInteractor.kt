package com.dfl.xkdc.interactor

import com.dfl.xkdc.mapper.ComicsMapper
import com.dfl.xkdc.network.XkcdServices
import com.dfl.xkdc.repository.ComicsRepository
import com.dfl.xkdc.uimodel.Comic
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * interactor to handle interactions with comics
 * @param service handle comic network requests
 * @param repository repository to save comics
 * @param mapper maps comics objects
 */
class ComicsInteractor(private val service: XkcdServices, private val repository: ComicsRepository, private val mapper: ComicsMapper) {

    /**
     * @return observable to retrieve latest comic from network
     */
    fun getComicNetwork(): Single<Comic> {
        return service.getComic()
                .map { mapper.convert(it) }
    }

    /**
     * @param id id of the comic to retrieve
     * @return observable to retrieve comic from network
     */
    fun getComicNetwork(id: Int): Single<Comic> {
        return service.getComic(id)
                .map { mapper.convert(it) }
    }

    /**
     * @param id id of the comic to retrieve
     * @return observable to retrieve comic from repository
     */
    fun getComicRepository(id: Int): Single<Comic> {
        return repository.getComic(id)
                .map { mapper.convert(it) }
    }

    /**
     * @param comic comic to insert
     * @return completable to insert comic to repository
     */
    fun insertComic(comic: Comic): Completable {
        return repository.insert(mapper.convert(comic))
    }

    /**
     * @param id id of the comic to fav
     * @return completable to fav comic
     */
    fun favComic(id: Int): Completable {
        return repository.favComic(id)
    }

    /**
     * @param id id of the comic to unFav
     * @return completable to unFav comic
     */
    fun unFavComic(id: Int): Completable {
        return repository.unFavComic(id)
    }

    /**
     * @return get all comics with fav
     */
    fun getFavourites(): Flowable<Comic> {
        return repository.getFavourites()
                .flatMapIterable { it }
                .map { mapper.convert(it) }
    }
}