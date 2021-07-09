package com.jan.melichallenge.apimanager.product

import com.google.gson.annotations.SerializedName
import com.jan.melichallenge.apimanager.paging.Paging

data class SearchProductsResponse(
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("query")
    val query: String,
    @SerializedName("results")
    val results: List<Product>,
    @SerializedName("site_id")
    val siteId: String
)