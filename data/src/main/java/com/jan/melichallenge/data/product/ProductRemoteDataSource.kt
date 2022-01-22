package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result

interface ProductRemoteDataSource {

    suspend fun searchProducts(
        query: String,
        offset: Int
    ): Result<List<Product>, Error<String, Throwable>>
}