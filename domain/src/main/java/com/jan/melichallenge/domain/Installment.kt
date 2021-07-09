package com.jan.melichallenge.domain

data class Installment(
    val amount: Double,
    val currencyId: String,
    val quantity: Int,
    val rate: Double
)