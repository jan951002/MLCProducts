package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Rating
import com.jan.melichallenge.serializable.RatingSerializable

fun RatingSerializable.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)

fun Rating.toRatingsParcelable() = RatingSerializable(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)
