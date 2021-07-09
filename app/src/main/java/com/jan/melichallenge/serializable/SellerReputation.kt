package com.jan.melichallenge.serializable

import java.io.Serializable

data class SellerReputation(
    val levelId: String?,
    val transactions: Transactions
) : Serializable

typealias SellerReputationSerializable = SellerReputation