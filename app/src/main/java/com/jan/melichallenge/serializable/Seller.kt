package com.jan.melichallenge.serializable

import java.io.Serializable

data class Seller(
    val carDealer: Boolean,
    val id: Long,
    val permalink: String?,
    val realEstateAgency: Boolean,
    val registrationDate: String?,
    val sellerReputation: SellerReputation?,
    val tags: List<String>?
) : Serializable

typealias SellerSerializable = Seller