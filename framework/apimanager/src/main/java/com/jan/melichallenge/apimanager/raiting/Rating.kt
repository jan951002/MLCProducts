package com.jan.melichallenge.apimanager.raiting

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("negative")
    val negative: Double,
    @SerializedName("neutral")
    val neutral: Double,
    @SerializedName("positive")
    val positive: Double
)
