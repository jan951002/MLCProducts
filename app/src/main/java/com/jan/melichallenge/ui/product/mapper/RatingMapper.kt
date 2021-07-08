package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.RatingParcelable
import com.jan.melichallenge.domain.Rating

fun RatingParcelable.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)

fun Rating.toRatingsParcelable() = RatingParcelable(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)