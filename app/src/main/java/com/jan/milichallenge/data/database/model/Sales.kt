package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo

data class Sales(
    val completed: Int,

    @ColumnInfo(name = "sales_period")
    val salesPeriod: String
)