package com.jan.milichallenge.domain.model

data class Seller(
    val carDealer: Boolean,
    val id: Long,
    val permalink: String,
    val realEstateAgency: Boolean,
    val registrationDate: String,
    val sellerReputation: SellerReputation,
    val tags: List<String>
)