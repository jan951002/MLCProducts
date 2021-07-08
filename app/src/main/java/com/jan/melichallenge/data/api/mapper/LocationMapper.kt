package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Location

fun com.jan.melichallenge.data.api.response.Location.toDomainLocation() = Location(
    name = this.name
)