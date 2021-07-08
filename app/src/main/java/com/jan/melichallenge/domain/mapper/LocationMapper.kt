package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.LocationResponse
import com.jan.melichallenge.domain.Location

fun LocationResponse.toDomainLocation() = Location(
    name = this.name
)