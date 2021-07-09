package com.jan.melichallenge.apimanager.product

import com.jan.melichallenge.apimanager.MeliApiServices
import com.jan.melichallenge.data.product.ProductRemoteDataSource
import com.jan.melichallenge.domain.Product

class ProductRemoteDataSourceImpl(private val meliApiServices: MeliApiServices) :
    ProductRemoteDataSource {

    override suspend fun searchProducts(query: String, offset: Int): List<Product> =
        meliApiServices.searchProducts(query, offset).results.map { it.toProductDomain() }
}