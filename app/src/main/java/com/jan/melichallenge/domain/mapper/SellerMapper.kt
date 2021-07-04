package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.SellerResponse
import com.jan.melichallenge.domain.model.Seller

fun SellerResponse.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationDomain(),
    tags = this.tags
)