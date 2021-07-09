package com.jan.melichallenge.imagemanager

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageExtension {

    fun ImageView.loadUrl(urlString: String, @DrawableRes placeholder: Int) {

        Glide.with(context)
            .load(urlString)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(placeholder)
            .into(this)
    }

    fun ImageView.loadDrawable(@DrawableRes drawableRes: Int) {
        setImageDrawable(ContextCompat.getDrawable(context, drawableRes))
    }
}