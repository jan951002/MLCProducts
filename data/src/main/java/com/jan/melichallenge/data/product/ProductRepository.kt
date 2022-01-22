package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result

interface ProductRepository {

    suspend fun searchProducts(
        query: String,
        offset: Int
    ): Result<List<Product>, Error<String, Throwable>>
}

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun searchProducts(query: String, offset: Int) =
        productRemoteDataSource.searchProducts(query, offset)
}