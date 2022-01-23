package com.jan.melichallenge.data.product

import com.jan.melichallenge.domain.Error
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Result

/**
 *  Interface to define the contracts of product remote dataSource
 *  @author Jaime Trujillo
 */
interface ProductRemoteDataSource {

    /**
     *  Function to search products from a query
     *  @param query Text used for find products
     *  @param offset Page index for search
     *  @author Jaime Trujillo
     */
    suspend fun searchProducts(
        query: String,
        offset: Int
    ): Result<List<Product>, Error<String, Throwable>>
}
