package com.jan.melichallenge.di

import com.jan.melichallenge.data.search.SearchLocalDataSource
import com.jan.melichallenge.databasemanager.MeliDatabase
import com.jan.melichallenge.databasemanager.provideMeliDatabase
import com.jan.melichallenge.databasemanager.search.SearchDao
import com.jan.melichallenge.databasemanager.search.SearchLocalDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module to configure room database dependency injection
 * @author Jaime Trujillo
 */
val databaseModule = module {

    single { provideMeliDatabase(androidApplication()) }

    single { provideSearchDao(meliDatabase = get()) }

    single { provideSearchLocalDataSource(searchDao = get()) }
}


/**
 *  function to build our SearchDao
 *  @param meliDatabase
 */
fun provideSearchDao(meliDatabase: MeliDatabase): SearchDao = meliDatabase.searchDao

/**
 *  function to build our SearchLocalDataSource
 *  @param searchDao
 */
fun provideSearchLocalDataSource(searchDao: SearchDao): SearchLocalDataSource =
    SearchLocalDataSourceImpl(searchDao)