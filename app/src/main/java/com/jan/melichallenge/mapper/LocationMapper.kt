package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Location
import com.jan.melichallenge.serializable.LocationSerializable

fun LocationSerializable.toLocationDomain() = Location(
    name = this.name
)

fun Location.toLocationParcelable() = LocationSerializable(
    name = this.name
)
