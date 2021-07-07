package com.jan.melichallenge.ui.product.model

import java.io.Serializable

data class SellerReputation(
    val levelId: String?,
    val transactions: Transactions
) : Serializable