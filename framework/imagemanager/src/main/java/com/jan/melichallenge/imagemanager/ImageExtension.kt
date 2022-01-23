package com.jan.melichallenge.imagemanager

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Function to load an Image from a URL
 * @param url URL of image
 * @param placeholder Local image as a placeholder
 * @author Jaime Trujillo
 */
fun ImageView.loadUrl(url: String, @DrawableRes placeholder: Int) {

    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .placeholder(placeholder)
        .into(this)
}

/**
 * Function to load an Image from a Drawable
 * @param drawableRes Local image as a placeholder
 * @author Jaime Trujillo
 */
fun ImageView.loadDrawable(@DrawableRes drawableRes: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, drawableRes))
}