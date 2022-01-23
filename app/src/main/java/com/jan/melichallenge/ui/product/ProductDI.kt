package com.jan.melichallenge.ui.product

import com.jan.melichallenge.data.product.ProductRepository
import com.jan.melichallenge.usecases.product.ProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 *  Module for defining product use case dependencies with the Hilt library
 *  @author Jaime Trujillo
 */
@Module
@InstallIn(ViewModelComponent::class)
class ProductDI {

    /**
     *  Function to provide a product list use case instance in the ViewModel scope
     *  @param productRepository To create the instance
     *  @author Jaime Trujillo
     */
    @Provides
    @ViewModelScoped
    fun productListUseCaseProvider(productRepository: ProductRepository) = ProductListUseCase(
        productRepository
    )
}