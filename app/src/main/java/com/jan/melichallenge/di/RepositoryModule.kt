package com.jan.melichallenge.di

import com.jan.melichallenge.data.product.ProductRemoteDataSource
import com.jan.melichallenge.data.product.ProductRepository
import com.jan.melichallenge.data.product.ProductRepositoryImpl
import com.jan.melichallenge.data.search.SearchLocalDataSource
import com.jan.melichallenge.data.search.SearchRepository
import com.jan.melichallenge.data.search.SearchRepositoryImpl
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