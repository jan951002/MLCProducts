package com.jan.melichallenge.apimanager.raiting

import com.jan.melichallenge.domain.Rating

fun com.jan.melichallenge.apimanager.raiting.Rating.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)