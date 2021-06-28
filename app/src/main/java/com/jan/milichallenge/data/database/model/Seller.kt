package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.TypeConverters
import com.jan.milichallenge.data.database.converter.DataListStringConverter

data class Seller(
    @ColumnInfo(name = "car_dealer")
    val carDealer: Boolean,

    val sellerId: Long,

    val sellerPermalink: String,

    @ColumnInfo(name = "real_estate_agency")
    val realEstateAgency: Boolean,

    @ColumnInfo(name = "registration_date")
    val registrationDate: String,

    @Embedded
    val sellerReputation: SellerReputation,

    @TypeConverters(DataListStringConverter::class)
    @ColumnInfo(name = "seller_tags")
    val sellerTags: List<String>
)