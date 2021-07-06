package com.jan.melichallenge.data.api.response

import com.google.gson.annotations.SerializedName

data class Transactions(
    @SerializedName("canceled")
    val canceled: Int,
    @SerializedName("completed")
    val completed: Int,
    @SerializedName("period")
    val period: String,
    @SerializedName("ratings")
    val ratings: Rating,
    @SerializedName("total")
    val total: Int
)