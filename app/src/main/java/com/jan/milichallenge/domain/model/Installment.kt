package com.jan.milichallenge.domain.model

data class Installment(
    val amount: Double,
    val currencyId: String,
    val quantity: Int,
    val rate: Double
)