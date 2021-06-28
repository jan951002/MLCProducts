package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.RatingsResponse
import com.jan.milichallenge.config.RatingsRoom
import com.jan.milichallenge.domain.model.Rating

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