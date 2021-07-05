package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.LocationResponse
import com.jan.melichallenge.domain.model.Location

fun LocationResponse.toDomainLocation() = Location(
    name = this.name
)