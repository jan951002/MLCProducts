package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Seller

fun com.jan.melichallenge.data.api.response.Seller.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationDomain(),
    tags = this.tags
)