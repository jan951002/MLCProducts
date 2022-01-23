package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.SellerAddress
import com.jan.melichallenge.serializable.SellerAddressSerializable

fun SellerAddressSerializable.toSellerAddressDomain() = SellerAddress(
    addressLine = this.addressLine,
    city = this.city.toLocationDomain(),
    comment = this.comment,
    country = this.country.toLocationDomain(),
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    state = this.state.toLocationDomain(),
    zipCode = this.zipCode
)

fun SellerAddress.toSellerAddressParcelable() = SellerAddressSerializable(
    addressLine = this.addressLine,
    city = this.city.toLocationParcelable(),
    comment = this.comment,
    country = this.country.toLocationParcelable(),
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    state = this.state.toLocationParcelable(),
    zipCode = this.zipCode
)
