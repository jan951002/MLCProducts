package com.jan.melichallenge.apimanager.seller

import com.jan.melichallenge.apimanager.seller.reputation.toSellerReputationDomain
import com.jan.melichallenge.domain.Seller

fun com.jan.melichallenge.apimanager.seller.Seller.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationDomain(),
    tags = this.tags
)
