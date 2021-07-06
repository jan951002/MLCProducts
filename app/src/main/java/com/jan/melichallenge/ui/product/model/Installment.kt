package com.jan.melichallenge.ui.product.model

import java.io.Serializable

data class Installment(
    val amount: Double,
    val currencyId: String,
    val quantity: Int,
    val rate: Double
) : Serializable