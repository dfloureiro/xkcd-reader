package com.dfl.xkdc.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.support.annotation.Keep

@Keep
@Database(entities = [ComicEntity::class], exportSchema = false, version = 1)
abstract class ComicsDatabase : RoomDatabase(){

    abstract fun getComicsDao() : ComicsDao
}