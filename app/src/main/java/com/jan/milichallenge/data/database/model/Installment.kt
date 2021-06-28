package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo

data class Installment(

    val amount: Double,

    @ColumnInfo(name = "installment_currency_id")
    val installmentCurrencyId: String,

    val quantity: Int,

    @ColumnInfo(name = "installment_rate")
    val installmentRate: Double
)