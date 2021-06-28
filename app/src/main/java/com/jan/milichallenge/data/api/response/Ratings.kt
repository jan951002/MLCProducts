package com.jan.milichallenge.data.api.response


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("negative")
    val negative: Double,
    @SerializedName("neutral")
    val neutral: Double,
    @SerializedName("positive")
    val positive: Double
)