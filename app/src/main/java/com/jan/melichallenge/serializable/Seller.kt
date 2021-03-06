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
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias SellerSerializable = Seller
