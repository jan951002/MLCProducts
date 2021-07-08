package com.jan.melichallenge.domain.repository

import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSource
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