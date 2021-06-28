package com.jan.milichallenge.data.api.response


import com.google.gson.annotations.SerializedName

data class SellerReputation(
    @SerializedName("level_id")
    val levelId: String?,
    @SerializedName("transactions")
    val transactions: Transactions
)