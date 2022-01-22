package com.jan.melichallenge.ui.product

import com.jan.melichallenge.data.product.ProductRepository
import com.jan.melichallenge.usecases.product.ProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ProductDI {

    @Provides
    @ViewModelScoped
    fun productListUseCaseProvider(productRepository: ProductRepository) = ProductListUseCase(
        productRepository
    )
}