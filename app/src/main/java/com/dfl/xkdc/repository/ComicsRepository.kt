package com.dfl.xkdc.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * comics repository
 *@param dao comics database
 */
class ComicsRepository(private val dao: ComicsDao) {

    /**
     * insert entity
     */
    fun insert(comic: ComicEntity): Completable {
        return Completable.fromAction { dao.insert(comic) }
    }

    /**
     * retrieve entity
     */
    fun getComic(id: Int): Single<ComicEntity> {
        return dao.getComic(id)
    }

    /**
     * retrieve all entities with fav
     */
    fun getFavourites(): Flowable<List<ComicEntity>> {
        return dao.getFavourites()
    }

    /**
     * update entity as fav
     */
    fun favComic(id: Int): Completable {
        return Completable.fromAction { dao.favComic(id) }
    }

    /**
     * update entity as unFav
     */
    fun unFavComic(id: Int): Completable {
        return Completable.fromAction { dao.unFavComic(id) }
    }
}