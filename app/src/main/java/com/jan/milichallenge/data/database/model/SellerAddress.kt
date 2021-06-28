package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class SellerAddress(
    @ColumnInfo(name = "address_line")
    val addressLine: String,

    @Embedded
    val city: City,

    val comment: String,

    @Embedded
    val country: Country,

    val sellerAddressId: String,

    val latitude: String,

    val longitude: String,

    @Embedded
    val state: State,

    @ColumnInfo(name = "zip_code")
    val zipCode: String
)