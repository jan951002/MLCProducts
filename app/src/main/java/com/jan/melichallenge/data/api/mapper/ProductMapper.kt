package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Product

fun com.jan.melichallenge.data.api.response.Product.toProductDomain() = Product(
    acceptsMercadopago = this.acceptsMercadopago,
    attributes = this.attributes.map { it.toAttributeDomain() },
    availableQuantity = this.availableQuantity,
    buyingMode = this.buyingMode,
    catalogListing = this.catalogListing,
    catalogProductId = this.catalogProductId,
    categoryId = this.categoryId,
    condition = this.condition,
    currencyId = this.currencyId,
    domainId = this.domainId,
    id = this.id,
    installments = this.installments?.toInstallmentDomain(),
    listingTypeId = this.listingTypeId,
    orderBackend = this.orderBackend,
    permalink = this.permalink,
    price = this.price,
    seller = this.seller.toSellerDomain(),
    siteId = this.siteId,
    soldQuantity = this.soldQuantity,
    stopTime = this.stopTime,
    tags = this.tags,
    thumbnail = this.thumbnail,
    thumbnailId = this.thumbnailId,
    title = this.title,
    useThumbnailId = this.useThumbnailId,
    sellerAddress = this.sellerAddress.toSellerAddressDomain()
)