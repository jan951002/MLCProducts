package com.jan.melichallenge.apimanager.seller.reputation

import com.google.gson.annotations.SerializedName
import com.jan.melichallenge.apimanager.transactions.Transactions

data class SellerReputation(
    @SerializedName("level_id")
    val levelId: String?,
    @SerializedName("transactions")
    val transactions: Transactions
)