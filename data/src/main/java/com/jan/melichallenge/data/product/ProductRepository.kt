package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Product

interface ProductRepository {

    suspend fun searchProducts(query: String, offset: Int): List<Product>
}

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun searchProducts(query: String, offset: Int) =
        productRemoteDataSource.searchProducts(query, offset)
}