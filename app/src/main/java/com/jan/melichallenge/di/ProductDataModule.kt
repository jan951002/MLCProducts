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

@Module
@InstallIn(SingletonComponent::class)
class ProductDataModule {

    @Provides
    @Singleton
    fun productRemoteDataSourceProvider(meliApiServices: MeliApiServices): ProductRemoteDataSource =
        ProductRemoteDataSourceImpl(meliApiServices)

    @Provides
    @Singleton
    fun productRepository(productRemoteDataSource: ProductRemoteDataSource): ProductRepository =
        ProductRepositoryImpl(productRemoteDataSource)
}