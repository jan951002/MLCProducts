package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.SellerResponse
import com.jan.melichallenge.config.SellerRoom
import com.jan.melichallenge.domain.model.Seller

fun SellerResponse.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.id,
    permalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation.toSellerReputationDomain(),
    tags = this.tags
)

fun SellerRoom.toSellerDomain() = Seller(
    carDealer = this.carDealer,
    id = this.sellerId,
    permalink = this.sellerPermalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation.toSellerReputationDomain(),
    tags = this.sellerTags
)

fun Seller.toSellerRoom() = SellerRoom(
    carDealer = this.carDealer,
    sellerId = this.id,
    sellerPermalink = this.permalink,
    realEstateAgency = this.realEstateAgency,
    registrationDate = this.registrationDate,
    sellerReputation = this.sellerReputation.toSellerReputationRoom(),
    sellerTags = this.tags
)