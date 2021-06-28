package com.jan.milichallenge.data.database.model


import androidx.room.*
import com.jan.milichallenge.data.database.converter.DataListAttributeConverter
import com.jan.milichallenge.data.database.converter.DataListStringConverter

@Entity(tableName = "products")
data class Product(

    @ColumnInfo(name = "accepts_mercadopago")
    val acceptsMercadopago: Boolean,

    @TypeConverters(DataListAttributeConverter::class)
    @ColumnInfo(name = "attributes")
    val attributes: List<Attribute>,

    @ColumnInfo(name = "available_quantity")
    val availableQuantity: Int,

    @ColumnInfo(name = "buying_mode")
    val buyingMode: String,

    @ColumnInfo(name = "catalog_listing")
    val catalogListing: Boolean,

    @ColumnInfo(name = "catalog_product_id")
    val catalogProductId: String,

    @ColumnInfo(name = "category_id")
    val categoryId: String,

    val condition: String,

    @ColumnInfo(name = "currency_id")
    val currencyId: String,

    @ColumnInfo(name = "domain_id")
    val domainId: String,

    val id: String,

    @Embedded
    val installments: Installment,

    @ColumnInfo(name = "listing_type_id")
    val listingTypeId: String,

    @ColumnInfo(name = "order_backend")
    val orderBackend: Int,

    @ColumnInfo(name = "permalink")
    val permalink: String,

    @ColumnInfo(name = "price")
    val price: Int,

    @Embedded
    val seller: Seller,

    @Embedded
    val sellerAddress: SellerAddress,

    @ColumnInfo(name = "site_id")
    val siteId: String,

    @ColumnInfo(name = "sold_quantity")
    val soldQuantity: Int,

    @ColumnInfo(name = "stop_time")
    val stopTime: String,

    @TypeConverters(DataListStringConverter::class)
    val tags: List<String>,

    val thumbnail: String,

    @ColumnInfo(name = "thumbnail_id")
    val thumbnailId: String,

    val title: String,

    @ColumnInfo(name = "use_thumbnail_id")
    val useThumbnailId: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id")
    var localId = 0L
}