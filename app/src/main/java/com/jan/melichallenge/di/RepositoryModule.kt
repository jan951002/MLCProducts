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

    single {
        provideProductRepository(
            productRemoteDataSource = get()
        )
    }

    single {
        provideSearchRepository(searchLocalDataSource = get())
    }
}

/**
 *  function to build our ProductRepository
 *  @param productRemoteDataSource
 */
fun provideProductRepository(
    productRemoteDataSource: ProductRemoteDataSource
): ProductRepository = ProductRepositoryImpl(productRemoteDataSource)

/**
 *  function to build our SearchRepository
 *  @param searchLocalDataSource
 */
fun provideSearchRepository(
    searchLocalDataSource: SearchLocalDataSource,
): SearchRepository = SearchRepositoryImpl(searchLocalDataSource)