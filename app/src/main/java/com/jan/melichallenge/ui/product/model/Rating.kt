package com.jan.melichallenge.ui.product.model

import java.io.Serializable

data class Rating(
    val negative: Double,
    val neutral: Double,
    val positive: Double
) : Serializable