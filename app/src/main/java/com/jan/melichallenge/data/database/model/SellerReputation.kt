package com.jan.melichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class SellerReputation(
    @ColumnInfo(name = "level_id")
    val levelId: String?,

    @Embedded
    val transactions: Transactions
)