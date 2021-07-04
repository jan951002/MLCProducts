package com.jan.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Rating,
    val total: Int
)