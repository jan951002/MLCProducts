package com.jan.melichallenge.apimanager.installment

import com.google.gson.annotations.SerializedName

data class Installment(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("rate")
    val rate: Double
)
