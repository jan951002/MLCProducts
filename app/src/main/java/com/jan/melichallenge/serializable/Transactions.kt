package com.jan.melichallenge.serializable

import java.io.Serializable

data class Transactions(
    val canceled: Int,
    val completed: Int,
    val period: String,
    val ratings: Rating,
    val total: Int
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias TransactionsSerializable = Transactions
