package com.jan.milichallenge.domain.model

data class SellerAddress(
    val addressLine: String,
    val city: Location,
    val comment: String,
    val country: Location,
    val id: String,
    val latitude: String,
    val longitude: String,
    val state: Location,
    val zipCode: String
)