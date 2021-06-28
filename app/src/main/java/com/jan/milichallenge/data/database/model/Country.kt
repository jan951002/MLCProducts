package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo

data class Country(
    @ColumnInfo(name = "country_name")
    val countryName:String
)
