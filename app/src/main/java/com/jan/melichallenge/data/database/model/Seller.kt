package com.jan.melichallenge.data.database.model

import androidx.room.*
import com.jan.melichallenge.data.database.converter.DataListStringConverter

@Entity(tableName = "seller")
data class Seller(
    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "car_dealer")
    val carDealer: Boolean,

    val sellerPermalink: String,

    @ColumnInfo(name = "real_estate_agency")
    val realEstateAgency: Boolean,

    @ColumnInfo(name = "registration_date")
    val registrationDate: String,

    @Embedded
    val sellerReputation: SellerReputation,

    @TypeConverters(DataListStringConverter::class)
    @ColumnInfo(name = "seller_tags")
    val sellerTags: List<String>,

    @Embedded
    val address: SellerAddress? = null
)