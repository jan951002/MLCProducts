package com.jan.melichallenge.domain

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Rating,
    val total: Int
)
