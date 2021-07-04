package com.jan.melichallenge.di

import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSource
import com.jan.melichallenge.domain.repository.ProductRepository
import com.jan.melichallenge.domain.repository.ProductRepositoryImpl
import com.jan.melichallenge.domain.repository.SearchRepository
import com.jan.melichallenge.usecase.ProductListUseCase
import com.jan.melichallenge.usecase.SaveSearchUseCase
import com.jan.melichallenge.usecase.SearchListUseCase
import org.koin.dsl.module

/**
 * Module to configure use cases dependency injection
 * @author Jaime Trujillo
 */

val useCaseModule = module {
    factory { provideProductListUseCase(productRepository = get()) }
    factory { provideSaveSearchUseCase(searchRepository = get()) }
    factory { provideSearchListUseCase(searchRepository = get()) }
}

/**
 *  function to build our ProductListUseCase
 *  @param productRepository
 */
fun provideProductListUseCase(
    productRepository: ProductRepository
): ProductListUseCase = ProductListUseCase(productRepository)

/**
 *  function to build our SaveSearchUseCase
 *  @param searchRepository
 */
fun provideSaveSearchUseCase(
    searchRepository: SearchRepository
): SaveSearchUseCase = SaveSearchUseCase(searchRepository)

/**
 *  function to build our SearchListUseCase
 *  @param searchRepository
 */
fun provideSearchListUseCase(
    searchRepository: SearchRepository
): SearchListUseCase = SearchListUseCase(searchRepository)