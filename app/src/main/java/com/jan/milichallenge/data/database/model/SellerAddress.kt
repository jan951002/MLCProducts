package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class SellerAddress(
    @ColumnInfo(name = "address_line")
    val addressLine: String,

    @ColumnInfo(name = "city_name")
    val cityName: String,

    val comment: String,

    @ColumnInfo(name = "country_name")
    val countryName: String,

    @ColumnInfo(name = "seller_address_id")
    val sellerAddressId: String,

    val latitude: String,

    val longitude: String,

    @ColumnInfo(name = "state_name")
    val stateName: String,

    @ColumnInfo(name = "zip_code")
    val zipCode: String
)