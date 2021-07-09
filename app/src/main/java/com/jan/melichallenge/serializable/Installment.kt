package com.jan.melichallenge.serializable

import java.io.Serializable

data class Installment(
    val amount: Double,
    val currencyId: String,
    val quantity: Int,
    val rate: Double
) : Serializable

typealias InstallmentSerializable = Installment