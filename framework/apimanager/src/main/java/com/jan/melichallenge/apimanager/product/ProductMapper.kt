package com.jan.melichallenge.apimanager.product

import com.jan.melichallenge.apimanager.attribute.toAttributeDomain
import com.jan.melichallenge.apimanager.installment.toInstallmentDomain
import com.jan.melichallenge.apimanager.seller.address.toSellerAddressDomain
import com.jan.melichallenge.apimanager.seller.toSellerDomain
import com.jan.melichallenge.domain.Product

fun com.jan.melichallenge.apimanager.product.Product.toProductDomain() = Product(
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