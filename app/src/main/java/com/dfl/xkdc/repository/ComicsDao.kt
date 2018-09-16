package com.dfl.xkdc.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.support.annotation.Keep
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * comics dao
 */
@Keep
@Dao
interface ComicsDao {

    /**
     * insert comic
     * @param comic entity to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comic: ComicEntity)

    /**
     * get comic
     * @param id id of the comic to retrieve
     * @return single to retrieve comic
     */
    @Query("SELECT * FROM ComicEntity WHERE id = :id")
    fun getComic(id: Int): Single<ComicEntity>

    /**
     * update comic as fav
     * @param id id of the comic to fav
     */
    @Query("UPDATE ComicEntity SET fav = 1 WHERE id = :id")
    fun favComic(id: Int)

    /**
     * update comic as unFav
     * @param id of the comic to unFav
     */
    @Query("UPDATE ComicEntity SET fav = 0 WHERE id = :id")
    fun unFavComic(id: Int)

    /**
     * get all comics with fav
     * @return observable with all fav comics
     */
    @Query("SELECT * FROM ComicEntity WHERE fav = 1 ORDER BY id DESC")
    fun getFavourites(): Flowable<List<ComicEntity>>
}
