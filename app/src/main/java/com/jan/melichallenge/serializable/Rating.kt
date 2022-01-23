package com.jan.melichallenge.serializable

import java.io.Serializable

data class Rating(
    val negative: Double,
    val neutral: Double,
    val positive: Double
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}

typealias RatingSerializable = Rating
