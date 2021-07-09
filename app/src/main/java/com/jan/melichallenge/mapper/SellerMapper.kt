package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Seller
import com.jan.melichallenge.serializable.SellerSerializable

fun SellerSerializable.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationDomain(),
    tags = this.tags
)

fun Seller.toSellerParcelable() = SellerSerializable(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationParcelable(),
    tags = this.tags
)