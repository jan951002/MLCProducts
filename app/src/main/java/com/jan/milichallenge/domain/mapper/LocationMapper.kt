package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.CityRoom
import com.jan.milichallenge.config.CountryRoom
import com.jan.milichallenge.config.StateRoom
import com.jan.milichallenge.domain.model.Location

fun com.jan.milichallenge.data.api.response.Location.toLocationDomain() =
    Location(
        name = this.name
    )

fun CityRoom.toLocationDomain() = Location(
    name = this.cityName
)

fun CountryRoom.toLocationDomain() = Location(
    name = this.countryName
)

fun StateRoom.toLocationDomain() = Location(
    name = this.stateName
)

fun Location.toCityRoom() = CityRoom(
    cityName = this.name
)

fun Location.toCountryRoom() = CountryRoom(
    countryName = this.name
)

fun Location.toStateRoom() = StateRoom(
    stateName = this.name
)