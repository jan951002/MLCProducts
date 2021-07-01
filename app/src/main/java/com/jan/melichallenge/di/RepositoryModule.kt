package com.jan.melichallenge.di

import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSource
import com.jan.melichallenge.data.database.datasource.SearchLocalDataSource
import com.jan.melichallenge.domain.repository.ProductRepository
import com.jan.melichallenge.domain.repository.ProductRepositoryImpl
import com.jan.melichallenge.domain.repository.SearchRepository
import com.jan.melichallenge.domain.repository.SearchRepositoryImpl
import org.koin.dsl.module

/**
 * Module to configure repositories dependency injection
 * @author Jaime Trujillo
 */

val repositoryModule = module {

    factory {
        provideProductRepository(
            searchLocalDataSource = get(),
            productRemoteDataSource = get()
        )
    }

    factory {
        provideSearchRepository(searchLocalDataSource = get())
    }
}

/**
 *  function to build our ProductRepository
 *  @param searchLocalDataSource
 *  @param productRemoteDataSource
 */
fun provideProductRepository(
    searchLocalDataSource: SearchLocalDataSource,
    productRemoteDataSource: ProductRemoteDataSource
): ProductRepository = ProductRepositoryImpl(searchLocalDataSource, productRemoteDataSource)

/**
 *  function to build our SearchRepository
 *  @param searchLocalDataSource
 */
fun provideSearchRepository(
    searchLocalDataSource: SearchLocalDataSource,
): SearchRepository = SearchRepositoryImpl(searchLocalDataSource)