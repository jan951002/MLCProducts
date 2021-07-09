package com.jan.melichallenge.ui.product.list

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jan.melichallenge.R
import com.jan.melichallenge.domain.Product
import com.jan.melichallenge.imagemanager.ImageExtension.loadUrl
import com.jan.melichallenge.textmanager.TextExtension.formatPrice

@BindingAdapter("productImage")
fun ImageView.setProductImage(product: Product) {
    loadUrl(product.thumbnail ?: "", R.drawable.ic_place_holder)
}

@BindingAdapter("productTitle")
fun TextView.setProductTitle(product: Product) {
    text = product.title
}

@BindingAdapter("productPrice")
fun TextView.setProductPrice(product: Product) {
    val price = product.price.formatPrice(product.currencyId ?: "")
    text = price
}
