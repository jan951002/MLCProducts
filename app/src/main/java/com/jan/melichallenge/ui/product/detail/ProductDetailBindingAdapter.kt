package com.jan.melichallenge.ui.product.detail

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jan.melichallenge.R
import com.jan.melichallenge.domain.Attribute
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.imagemanager.loadUrl
import com.jan.melichallenge.textmanager.formatPrice

@BindingAdapter("productDetailImage")
fun ImageView.setProductDetailImage(product: Product) {
    loadUrl(product.thumbnail ?: "", R.drawable.ic_place_holder)
}

@BindingAdapter("productDetailTitle")
fun TextView.setProductDetailTitle(product: Product) {
    text = product.title
}

@BindingAdapter("productDetailPrice")
fun TextView.setProductDetailPrice(product: Product) {
    val price =
        "${context.getString(R.string.lab_price)}: ${product.price.formatPrice(product.currencyId ?: "")}"
    text = price
}

@BindingAdapter("productDetailAvailableQuantity")
fun TextView.setProductDetailAvailableQuantity(product: Product) {
    val availableQuantity =
        "${context.getString(R.string.lab_available_quantity)}: ${product.availableQuantity}"
    text = availableQuantity
}

@BindingAdapter("productDetailSellerUrl")
fun TextView.setProductDetailSellerURL(product: Product) {
    val url = "${product.seller.permalink}"
    text = url
}

@BindingAdapter("productDetailSellerLocation")
fun TextView.setProductDetailSellerLocation(product: Product) {
    val location = "${product.sellerAddress.city.name}, ${product.sellerAddress.country.name}"
    text = location
}

@BindingAdapter("productDetailAttribute")
fun TextView.setProductDetailAttribute(attribute: Attribute) {
    val attributeText = "${attribute.name ?: ""}: ${attribute.valueName ?: ""}"
    text = attributeText
}