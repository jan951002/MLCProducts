package com.jan.melichallenge.apimanager.seller.address

import com.jan.melichallenge.apimanager.location.toDomainLocation
import com.jan.melichallenge.domain.SellerAddress

fun com.jan.melichallenge.apimanager.seller.address.SellerAddress.toSellerAddressDomain() = SellerAddress(
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