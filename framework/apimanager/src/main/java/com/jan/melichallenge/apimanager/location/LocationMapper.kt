package com.jan.melichallenge.apimanager.location

import com.jan.melichallenge.domain.Location

fun com.jan.melichallenge.apimanager.location.Location.toDomainLocation() = Location(
    name = this.name
)