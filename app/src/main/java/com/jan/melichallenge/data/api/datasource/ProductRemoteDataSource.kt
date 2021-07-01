package com.jan.melichallenge.data.api.datasource

import com.jan.melichallenge.data.api.MeliApiServices
import com.jan.melichallenge.domain.mapper.toProductDomain
import com.jan.melichallenge.domain.model.Product

interface ProductRemoteDataSource {
    suspend fun searchProducts(query: String, offset: Int): List<Product>
}

class ProductRemoteDataSourceImpl(private val meliApiServices: MeliApiServices) :
    ProductRemoteDataSource {

    override suspend fun searchProducts(query: String, offset: Int): List<Product> =
        meliApiServices.searchProducts(query, offset).results.map { it.toProductDomain() }
}