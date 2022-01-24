package com.jan.melichallenge.testmanager.product

import com.jan.melichallenge.domain.Installment
import com.jan.melichallenge.domain.Location
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.domain.Seller
import com.jan.melichallenge.domain.SellerAddress


val firstInstallment = Installment(
    amount = 123.0,
    currencyId = "ARS",
    quantity = 1,
    rate = 9.0
)

val firstSeller = Seller(
    carDealer = true,
    id = 123L,
    permalink = "any URL",
    realEstateAgency = true,
    registrationDate = "01-02-2000",
    sellerReputation = null,
    tags = listOf()
)

val firstLocation = Location(
    name = "Location"
)

val firstSellerAddress = SellerAddress(
    addressLine = "123 address",
    city = firstLocation,
    comment = "comment",
    country = firstLocation,
    id = "123SA",
    latitude = "0.0",
    longitude = "0.0",
    state = firstLocation,
    zipCode = "710001"
)

val firstProduct = Product(
    acceptsMercadopago = true,
    attributes = listOf(),
    availableQuantity = 1,
    buyingMode = "buying mode",
    catalogListing = true,
    catalogProductId = "123C",
    categoryId = "123C",
    condition = "condition",
    currencyId = "ARS",
    domainId = "123D",
    id = "123ABC",
    installments = firstInstallment,
    listingTypeId = "123LT",
    orderBackend = 1,
    permalink = "any URL",
    price = 123.0,
    seller = firstSeller,
    sellerAddress = firstSellerAddress,
    siteId = "123S",
    soldQuantity = 30,
    stopTime = null,
    tags = listOf(),
    thumbnail = null,
    thumbnailId = null,
    title = "First title",
    useThumbnailId = true
)

val secondProduct = Product(
    acceptsMercadopago = true,
    attributes = listOf(),
    availableQuantity = 1,
    buyingMode = "buying mode",
    catalogListing = true,
    catalogProductId = "123C",
    categoryId = "123C",
    condition = "condition",
    currencyId = "ARS",
    domainId = "123D",
    id = "456ABC",
    installments = firstInstallment,
    listingTypeId = "123LT",
    orderBackend = 1,
    permalink = "any URL",
    price = 123.0,
    seller = firstSeller,
    sellerAddress = firstSellerAddress,
    siteId = "123S",
    soldQuantity = 30,
    stopTime = null,
    tags = listOf(),
    thumbnail = null,
    thumbnailId = null,
    title = "Second title",
    useThumbnailId = true
)

val productList = listOf(firstProduct, secondProduct)
