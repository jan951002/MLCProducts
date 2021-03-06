package com.jan.melichallenge.domain

data class Seller(
    val carDealer: Boolean,
    val id: Long,
    val permalink: String?,
    val realEstateAgency: Boolean,
    val registrationDate: String?,
    val sellerReputation: SellerReputation?,
    val tags: List<String>?
)
