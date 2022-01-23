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

/**
 *  Module to define search data dependencies with Hilt library
 *  @author Jaime Trujillo
 */
@Module
@InstallIn(SingletonComponent::class)
class SearchDataModule {

    /**
     *  Function to provide a singleton instance of search DAO
     *  @param meliDatabase To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun searchDaoProvider(meliDatabase: MeliDatabase) = meliDatabase.searchDao

    /**
     *  Function to provide a singleton instance of search local datasource
     *  @param searchDao To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun searchLocalDataSourceProvider(searchDao: SearchDao): SearchLocalDataSource =
        SearchLocalDataSourceImpl(searchDao)

    /**
     *  Function to provide a singleton instance of search repository
     *  @param searchLocalDataSource To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun searchRepositoryProvider(searchLocalDataSource: SearchLocalDataSource): SearchRepository =
        SearchRepositoryImpl(searchLocalDataSource)
}
