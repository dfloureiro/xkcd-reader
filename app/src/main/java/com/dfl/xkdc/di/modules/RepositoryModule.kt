package com.dfl.xkdc.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.dfl.xkdc.comics.ComicsInteractor
import com.dfl.xkdc.comics.uimodel.ComicsMapper
import com.dfl.xkdc.database.ComicsDao
import com.dfl.xkdc.database.ComicsDatabase
import com.dfl.xkdc.database.ComicsRepository
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
    fun providedComicsRepository(dao: ComicsDao): ComicsRepository {
        return ComicsRepository(dao)
    }

    @Provides
    @Singleton
    fun providesComicsInteractor(services: XkcdServices, repository: ComicsRepository, mapper: ComicsMapper): ComicsInteractor {
        return ComicsInteractor(services, repository, mapper)
    }
}