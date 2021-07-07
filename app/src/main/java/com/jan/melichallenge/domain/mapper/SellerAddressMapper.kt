package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.SellerAddressResponse
import com.jan.melichallenge.domain.model.SellerAddress

fun SellerAddressResponse.toSellerAddressDomain() = SellerAddress(
    addressLine = this.addressLine,
    city = this.city.toDomainLocation(),
    comment = this.comment,
    country = this.country.toDomainLocation(),
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude,
    state = this.state.toDomainLocation(),
    zipCode = this.zipCode
)