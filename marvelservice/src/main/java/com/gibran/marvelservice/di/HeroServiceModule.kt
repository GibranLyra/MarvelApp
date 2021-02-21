package com.gibran.marvelservice.di

import androidx.room.Room
import com.gibran.marvelservice.database.AppDatabase
import com.gibran.marvelservice.api.MarvelRepository
import com.gibran.marvelservice.api.local.MarvelLocalDataSource
import com.gibran.marvelservice.api.remote.MarvelRemoteDataSource
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

@ExperimentalSerializationApi
object HeroServiceModule {
    val dataSourceModule = module {
        single { MarvelRemoteDataSource(get()) }
        single { MarvelLocalDataSource(get<AppDatabase>().heroDao()) }

        single {
            Room.databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            ).build()
        }
    }

    val repositoryModule = module {
        single {
            MarvelRepository(get() as MarvelRemoteDataSource, get() as MarvelLocalDataSource)
        }
    }
}
