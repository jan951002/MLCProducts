package com.jan.milichallenge.data.api

import com.jan.milichallenge.data.api.response.SearchProductsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MeliApiServices {

    @GET("MLA/search")
    suspend fun searchProducts(
        @Query("q") query: String, @Query("offset") offset: Int
    ): SearchProductsResponse
}