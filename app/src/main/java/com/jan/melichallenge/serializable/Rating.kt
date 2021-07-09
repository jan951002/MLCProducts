package com.jan.melichallenge.serializable

import java.io.Serializable

data class Rating(
    val negative: Double,
    val neutral: Double,
    val positive: Double
) : Serializable

typealias RatingSerializable = Rating