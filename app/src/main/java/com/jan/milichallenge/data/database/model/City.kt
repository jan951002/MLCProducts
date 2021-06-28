package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo

data class City(
    @ColumnInfo(name = "city_name")
    val cityName: String
)
