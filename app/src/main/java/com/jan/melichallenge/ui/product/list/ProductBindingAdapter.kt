package com.jan.melichallenge.ui.product.list

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jan.melichallenge.domain.model.Product
import com.jan.melichallenge.util.LoadImageUtil.loadUrl
import com.jan.melichallenge.util.TextUtil.formatPrice

@BindingAdapter("productImage")
fun ImageView.setProductImage(product: Product) {
    loadUrl(product.thumbnail ?: "")
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
