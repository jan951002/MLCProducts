package com.jan.melichallenge.serializable

import java.io.Serializable

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
) : Serializable

typealias SellerAddressSerializable = SellerAddress