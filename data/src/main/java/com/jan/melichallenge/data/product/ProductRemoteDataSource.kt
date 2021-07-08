package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Product

interface ProductRemoteDataSource {
    suspend fun searchProducts(query: String, offset: Int): List<Product>
}