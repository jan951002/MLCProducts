package com.jan.melichallenge.di

import com.jan.melichallenge.apimanager.MeliApiServices
import com.jan.melichallenge.apimanager.product.ProductRemoteDataSourceImpl
import com.jan.melichallenge.data.product.ProductRemoteDataSource
import com.jan.melichallenge.data.product.ProductRepository
import com.jan.melichallenge.data.product.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *  Module to define product data dependencies with Hilt library
 *  @author Jaime Trujillo
 */
@Module
@InstallIn(SingletonComponent::class)
class ProductDataModule {

    /**
     *  Function to provide a singleton instance of product remote datasource
     *  @param meliApiServices To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun productRemoteDataSourceProvider(meliApiServices: MeliApiServices): ProductRemoteDataSource =
        ProductRemoteDataSourceImpl(meliApiServices)

    /**
     *  Function to provide a singleton instance of product repository
     *  @param productRemoteDataSource To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @Singleton
    fun productRepository(productRemoteDataSource: ProductRemoteDataSource): ProductRepository =
        ProductRepositoryImpl(productRemoteDataSource)
}