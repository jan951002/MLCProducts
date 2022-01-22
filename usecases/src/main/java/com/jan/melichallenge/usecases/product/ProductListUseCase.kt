package com.jan.melichallenge.usecases.product

import com.jan.melichallenge.data.product.ProductRepository

class ProductListUseCase(private val productRepository: ProductRepository) {

    suspend fun invoke(query: String, offset: Int) = productRepository.searchProducts(query, offset)
}