package com.jan.melichallenge.di

import com.jan.melichallenge.data.product.ProductRepository
import com.jan.melichallenge.data.search.SearchRepository
import com.jan.melichallenge.usecases.ProductListUseCase
import com.jan.melichallenge.usecases.SaveSearchUseCase
import com.jan.melichallenge.usecases.SearchListUseCase
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