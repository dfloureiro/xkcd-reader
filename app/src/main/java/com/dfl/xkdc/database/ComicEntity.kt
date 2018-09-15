package com.dfl.xkdc.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Keep

@Keep
@Entity
data class ComicEntity(@PrimaryKey val id: Int,
                       @ColumnInfo(name = "title") val title: String,
                       @ColumnInfo(name = "imageUrl") val imageUrl: String,
                       @ColumnInfo(name = "alt") val alt: String,
                       @ColumnInfo(name = "fav") val fav: Boolean)
