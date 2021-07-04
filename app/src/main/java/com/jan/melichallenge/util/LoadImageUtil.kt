package com.jan.melichallenge.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jan.melichallenge.R

object LoadImageUtil {

    fun ImageView.loadUrl(urlString: String) {
        Glide.with(context)
            .load(urlString)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            //.centerCrop()
            .placeholder(R.drawable.ic_place_holder)
            .into(this)
    }
}