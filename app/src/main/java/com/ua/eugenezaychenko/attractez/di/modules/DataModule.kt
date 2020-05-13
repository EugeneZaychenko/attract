package com.ua.eugenezaychenko.attractez.di.modules

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.ua.eugenezaychenko.attractez.data.IRetrofitHelper
import com.ua.eugenezaychenko.attractez.data.RetrofitHelper
import com.ua.eugenezaychenko.attractez.data.repository.FilmsRemoteDataManager
import com.ua.eugenezaychenko.attractez.data.repository.FilmsRepository
import com.ua.eugenezaychenko.attractez.data.repository.IFilmsRemoteDataManager
import com.ua.eugenezaychenko.attractez.data.repository.IFilmsRepository
import com.ua.eugenezaychenko.attractez.data.repository.db.AppDatabase
import com.ua.eugenezaychenko.attractez.data.repository.db.dao.FilmDao
import com.ua.eugenezaychenko.attractez.data.repository.managers.BitmapManager
import com.ua.eugenezaychenko.attractez.data.repository.managers.IBitmapManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRetrofitApi(retrofitHelper: RetrofitHelper): IRetrofitHelper

    @Binds
    @Singleton
    abstract fun provideBitmapManagers(bitmapManagers: BitmapManager): IBitmapManager

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun appDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "attract_db")
                    .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideGson() = Gson()

        @JvmStatic
        @Provides
        @Singleton
        fun provideFilmsRepository(context: Context,
                                   bitmapManager: IBitmapManager,
                                   remoteDataManager: IFilmsRemoteDataManager,
                                   filmDao: FilmDao): IFilmsRepository =
                FilmsRepository(
                        context = context,
                        bitmapManager = bitmapManager,
                        remoteDataManager = remoteDataManager,
                        filmDao = filmDao)

        @JvmStatic
        @Provides
        @Singleton
        fun provideRemoteDataManager(retrofitHelper: IRetrofitHelper): IFilmsRemoteDataManager =
                FilmsRemoteDataManager(retrofitHelper.getAttractService())

        @JvmStatic
        @Provides
        @Singleton
        fun filmDao(appDatabase: AppDatabase): FilmDao = appDatabase.filmDao()

    }
}