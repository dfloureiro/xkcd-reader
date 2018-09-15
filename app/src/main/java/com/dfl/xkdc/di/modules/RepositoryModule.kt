package com.dfl.xkdc.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.dfl.xkdc.comics.ComicsRepository
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.database.ComicsDao
import com.dfl.xkdc.database.ComicsDatabase
import com.dfl.xkdc.database.ComicsDatabaseInteractor
import com.dfl.xkdc.network.XkcdServices
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class RepositoryModule(private val context: Context) {

    private val databaseName = "xkdc_comics_database"

    @Provides
    @Singleton
    fun providesComicsMapper(): ComicsMapper {
        return ComicsMapper()
    }

    @Provides
    @Singleton
    fun providesComicsDao(): ComicsDao {
        return Room.databaseBuilder(context.applicationContext, ComicsDatabase::class.java, databaseName).build().getComicsDao()
    }

    @Provides
    @Singleton
    fun providedComicsDatabaseInteractor(dao: ComicsDao): ComicsDatabaseInteractor {
        return ComicsDatabaseInteractor(dao)
    }

    @Provides
    @Singleton
    fun providesComicsRepository(services: XkcdServices, interactor: ComicsDatabaseInteractor, mapper: ComicsMapper): ComicsRepository {
        return ComicsRepository(services, interactor, mapper)
    }
}