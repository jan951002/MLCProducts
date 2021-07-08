package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.SellerParcelable
import com.jan.melichallenge.domain.Seller

fun SellerParcelable.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationDomain(),
    tags = this.tags
)

fun Seller.toSellerParcelable() = SellerParcelable(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation?.toSellerReputationParcelable(),
    tags = this.tags
)