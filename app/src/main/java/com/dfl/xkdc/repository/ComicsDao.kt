package com.dfl.xkdc.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.support.annotation.Keep
import io.reactivex.Flowable
import io.reactivex.Single

@Keep
@Dao
interface ComicsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comic: ComicEntity)

    @Query("SELECT * FROM ComicEntity WHERE id = :id")
    fun getComic(id: Int): Single<ComicEntity>

    @Query("UPDATE ComicEntity SET fav = 1 WHERE id = :id")
    fun favComic(id: Int)

    @Query("UPDATE ComicEntity SET fav = 0 WHERE id = :id")
    fun unFavComic(id: Int)

    @Query("SELECT * FROM ComicEntity WHERE fav = 1 ORDER BY id DESC")
    fun getFavourites(): Flowable<List<ComicEntity>>
}
