package com.jan.melichallenge.di

import com.jan.melichallenge.data.search.SearchLocalDataSource
import com.jan.melichallenge.data.search.SearchRepository
import com.jan.melichallenge.data.search.SearchRepositoryImpl
import com.jan.melichallenge.databasemanager.MeliDatabase
import com.jan.melichallenge.databasemanager.search.SearchDao
import com.jan.melichallenge.databasemanager.search.SearchLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchDataModule {

    @Provides
    @Singleton
    fun searchDaoProvider(meliDatabase: MeliDatabase) = meliDatabase.searchDao

    @Provides
    @Singleton
    fun searchLocalDataSourceProvider(searchDao: SearchDao): SearchLocalDataSource =
        SearchLocalDataSourceImpl(searchDao)

    @Provides
    @Singleton
    fun searchRepositoryProvider(searchLocalDataSource: SearchLocalDataSource): SearchRepository =
        SearchRepositoryImpl(searchLocalDataSource)
}