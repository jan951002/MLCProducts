package com.jan.melichallenge.apimanager.product

import com.google.gson.annotations.SerializedName
import com.jan.melichallenge.apimanager.attribute.Attribute
import com.jan.melichallenge.apimanager.installment.Installment
import com.jan.melichallenge.apimanager.seller.Seller
import com.jan.melichallenge.apimanager.seller.address.SellerAddress

data class Product(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("buying_mode")
    val buyingMode: String?,
    @SerializedName("catalog_listing")
    val catalogListing: Boolean,
    @SerializedName("catalog_product_id")
    val catalogProductId: String?,
    @SerializedName("category_id")
    val categoryId: String?,
    @SerializedName("condition")
    val condition: String?,
    @SerializedName("currency_id")
    val currencyId: String?,
    @SerializedName("domain_id")
    val domainId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("installments")
    val installments: Installment?,
    @SerializedName("listing_type_id")
    val listingTypeId: String?,
    @SerializedName("order_backend")
    val orderBackend: Int,
    @SerializedName("permalink")
    val permalink: String?,
    @SerializedName("price")
    val price: Double,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("seller_address")
    val sellerAddress: SellerAddress,
    @SerializedName("site_id")
    val siteId: String?,
    @SerializedName("sold_quantity")
    val soldQuantity: Int,
    @SerializedName("stop_time")
    val stopTime: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("thumbnail_id")
    val thumbnailId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean
)