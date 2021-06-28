package com.jan.milichallenge.data.api.response

import com.google.gson.annotations.SerializedName

data class SellerAddress(
    @SerializedName("address_line")
    val addressLine: String,
    @SerializedName("city")
    val city: Location,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("country")
    val country: Location,
    @SerializedName("id")
    val id: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("state")
    val state: Location,
    @SerializedName("zip_code")
    val zipCode: String
)