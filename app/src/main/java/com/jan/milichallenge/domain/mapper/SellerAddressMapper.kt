package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.SellerAddressResponse
import com.jan.milichallenge.config.SellerAddressRoom
import com.jan.milichallenge.domain.model.SellerAddress

fun SellerAddressResponse.toSellerAddressDomain() = SellerAddress(
    addressLine = this.addressLine,
    cityName = this.city.name,
    comment = this.comment,
    countryName = this.country.name,
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    stateName = this.state.name,
    zipCode = this.zipCode
)

fun SellerAddressRoom.toSellerAddressDomain() = SellerAddress(
    addressLine = this.addressLine,
    cityName = this.cityName,
    comment = this.comment,
    countryName = this.countryName,
    id = this.sellerAddressId,
    latitude = this.latitude,
    longitude = this.longitude,
    stateName = this.stateName,
    zipCode = this.zipCode
)

fun SellerAddress.toSellerAddressRoom() = SellerAddressRoom(
    addressLine = this.addressLine,
    cityName = this.cityName,
    comment = this.comment,
    countryName = this.countryName,
    sellerAddressId = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    stateName = this.stateName,
    zipCode = this.zipCode
)