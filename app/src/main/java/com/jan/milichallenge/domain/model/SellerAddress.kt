package com.jan.milichallenge.domain.model

data class SellerAddress(
    val addressLine: String,
    val cityName: String,
    val comment: String,
    val countryName: String,
    val id: String,
    val latitude: String,
    val longitude: String,
    val stateName: String,
    val zipCode: String
)