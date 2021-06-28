package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Transactions(
    val canceled: Int,

    val completed: Int,

    @ColumnInfo(name = "transaction_period")
    val transactionPeriod: String,

    @Embedded
    val ratings: Rating,

    val total: Int
)