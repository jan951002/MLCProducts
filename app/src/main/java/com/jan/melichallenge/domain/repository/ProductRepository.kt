package com.jan.melichallenge.domain.repository

import com.jan.melichallenge.data.api.datasource.ProductRemoteDataSource
import com.jan.melichallenge.domain.model.Product

interface ProductRepository {

    suspend fun checkRequireNewPage(query: String, offset: Int): List<Product>
}

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    companion object {
        private const val PAGE_SIZE = 50
    }

    override suspend fun checkRequireNewPage(query: String, offset: Int) =
        if (offset == 0 || offset % PAGE_SIZE == 0) {
            productRemoteDataSource.searchProducts(query, offset)
        } else {
            listOf()
        }
}