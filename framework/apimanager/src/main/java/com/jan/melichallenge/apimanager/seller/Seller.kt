package com.jan.melichallenge.apimanager.seller

import com.google.gson.annotations.SerializedName
import com.jan.melichallenge.apimanager.seller.reputation.SellerReputation

data class Seller(
    @SerializedName("car_dealer")
    val carDealer: Boolean,
    @SerializedName("id")
    val id: Long,
    @SerializedName("permalink")
    val permalink: String?,
    @SerializedName("real_estate_agency")
    val realEstateAgency: Boolean,
    @SerializedName("registration_date")
    val registrationDate: String?,
    @SerializedName("seller_reputation")
    val sellerReputation: SellerReputation?,
    @SerializedName("tags")
    val tags: List<String>?
)