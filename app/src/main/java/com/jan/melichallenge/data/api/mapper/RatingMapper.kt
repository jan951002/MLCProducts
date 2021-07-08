package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Rating

fun com.jan.melichallenge.data.api.response.Rating.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)