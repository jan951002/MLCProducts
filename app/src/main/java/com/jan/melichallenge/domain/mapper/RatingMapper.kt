package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.RatingsResponse
import com.jan.melichallenge.config.RatingsRoom
import com.jan.melichallenge.domain.model.Rating

fun RatingsResponse.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)

fun RatingsRoom.toRatingsDomain() = Rating(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)

fun Rating.toRatingsRoom() = RatingsRoom(
    negative = this.negative,
    neutral = this.neutral,
    positive = this.positive
)