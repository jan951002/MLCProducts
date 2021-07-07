package com.jan.melichallenge.ui.product.model

import java.io.Serializable

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Rating,
    val total: Int
) : Serializable