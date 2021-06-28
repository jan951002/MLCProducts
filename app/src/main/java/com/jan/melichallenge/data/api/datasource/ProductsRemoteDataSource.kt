package com.jan.melichallenge.data.api.datasource

import com.jan.melichallenge.data.api.MeliApiServices

interface ProductsRemoteDataSource {
    //suspend fun searchProducts(query: String, offset: Int)
}

private class ProductsRemoteDataSourceImpl(private val meliApiServices: MeliApiServices) :
    ProductsRemoteDataSource {

}