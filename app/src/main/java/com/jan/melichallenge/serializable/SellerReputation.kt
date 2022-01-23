package com.jan.melichallenge.serializable

import java.io.Serializable

data class SellerReputation(
    val levelId: String?,
    val transactions: Transactions
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias SellerReputationSerializable = SellerReputation
