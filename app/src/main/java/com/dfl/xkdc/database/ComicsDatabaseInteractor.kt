package com.dfl.xkdc.database

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class ComicsDatabaseInteractor(private val dao: ComicsDao) {

    fun insert(comic: ComicEntity): Completable {
        return Completable.fromAction { dao.insert(comic) }
    }

    fun getComic(id : Int) : Single<ComicEntity>{
        return dao.getComic(id)
    }

    fun getFavourites(): Flowable<List<ComicEntity>> {
        return dao.getFavourites()
    }

    fun favComic(id: Int): Completable {
        return Completable.fromAction { dao.favComic(id) }
    }

    fun unFavComic(id: Int): Completable {
        return Completable.fromAction { dao.unFavComic(id) }
    }
}