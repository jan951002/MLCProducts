package com.jan.melichallenge.di

import android.app.Application
import androidx.room.Room
import com.jan.melichallenge.data.database.MeliDatabase
import com.jan.melichallenge.data.database.dao.SearchDao
import com.jan.melichallenge.data.database.datasource.SearchLocalDataSource
import com.jan.melichallenge.data.database.datasource.SearchLocalDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module to configure room database dependency injection
 * @author Jaime Trujillo
 */
val databaseModule = module {

    single { provideMeliDatabase(androidApplication()) }

    single { provideProductDao(meliDatabase = get()) }

    single { provideSearchDao(meliDatabase = get()) }

    single { provideSearchLocalDataSource(searchDao = get()) }
}

/**
 *  function to build our MeliDatabase
 *  @param application
 */
fun provideMeliDatabase(application: Application): MeliDatabase =
    Room.databaseBuilder(application, MeliDatabase::class.java, "meli-db")
        .fallbackToDestructiveMigration()
        .build()

/**
 *  function to build our ProductDao
 *  @param meliDatabase
 */
fun provideProductDao(meliDatabase: MeliDatabase) = meliDatabase.productDao

/**
 *  function to build our SearchDao
 *  @param meliDatabase
 */
fun provideSearchDao(meliDatabase: MeliDatabase) = meliDatabase.searchDao

/**
 *  function to build our SearchLocalDataSource
 *  @param searchDao
 */
fun provideSearchLocalDataSource(searchDao: SearchDao): SearchLocalDataSource = SearchLocalDataSourceImpl(searchDao)