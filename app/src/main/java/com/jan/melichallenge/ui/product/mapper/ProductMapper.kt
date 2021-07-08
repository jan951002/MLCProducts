package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.ProductParcelable
import com.jan.melichallenge.domain.Product

fun ProductParcelable.toProductDomain() = Product(
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

fun Product.toProductParcelable() = ProductParcelable(
    acceptsMercadopago = this.acceptsMercadopago,
    attributes = this.attributes.map { it.toAttributeParcelable() },
    availableQuantity = this.availableQuantity,
    buyingMode = this.buyingMode,
    catalogListing = this.catalogListing,
    catalogProductId = this.catalogProductId,
    categoryId = this.categoryId,
    condition = this.condition,
    currencyId = this.currencyId,
    domainId = this.domainId,
    id = this.id,
    installments = this.installments?.toInstallmentParcelable(),
    listingTypeId = this.listingTypeId,
    orderBackend = this.orderBackend,
    permalink = this.permalink,
    price = this.price,
    seller = this.seller.toSellerParcelable(),
    siteId = this.siteId,
    soldQuantity = this.soldQuantity,
    stopTime = this.stopTime,
    tags = this.tags,
    thumbnail = this.thumbnail,
    thumbnailId = this.thumbnailId,
    title = this.title,
    useThumbnailId = this.useThumbnailId,
    sellerAddress = this.sellerAddress.toSellerAddressParcelable()
)