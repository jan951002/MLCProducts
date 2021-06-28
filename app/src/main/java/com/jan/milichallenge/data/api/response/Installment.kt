package com.jan.milichallenge.data.api.response


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