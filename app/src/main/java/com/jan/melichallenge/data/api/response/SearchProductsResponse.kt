package com.jan.melichallenge.data.api.response


import com.google.gson.annotations.SerializedName

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