package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.SellerAddress

fun com.jan.melichallenge.data.api.response.SellerAddress.toSellerAddressDomain() = SellerAddress(
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