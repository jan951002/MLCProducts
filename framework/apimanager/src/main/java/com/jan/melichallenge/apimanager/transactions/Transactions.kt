package com.jan.melichallenge.apimanager.transactions

import com.google.gson.annotations.SerializedName
import com.jan.melichallenge.apimanager.raiting.Rating

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