package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.LocationParcelable
import com.jan.melichallenge.domain.model.Location

fun LocationParcelable.toLocationDomain() = Location(
    name = this.name
)

fun Location.toLocationParcelable() = LocationParcelable(
    name = this.name
)