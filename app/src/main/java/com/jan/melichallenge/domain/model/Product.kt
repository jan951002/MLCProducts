package com.jan.melichallenge.domain.model

data class Product(
    val acceptsMercadopago: Boolean,
    val attributes: List<Attribute>,
    val availableQuantity: Int,
    val buyingMode: String,
    val catalogListing: Boolean,
    val catalogProductId: String,
    val categoryId: String,
    val condition: String,
    val currencyId: String,
    val domainId: String,
    val id: String,
    val installments: Installment,
    val listingTypeId: String,
    val orderBackend: Int,
    val permalink: String,
    val price: Int,
    val sellerId: Long,
    val siteId: String,
    val soldQuantity: Int,
    val stopTime: String,
    val tags: List<String>,
    val thumbnail: String,
    val thumbnailId: String,
    val title: String,
    val useThumbnailId: Boolean
)