package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.SellerAddressParcelable
import com.jan.melichallenge.domain.model.SellerAddress

fun SellerAddressParcelable.toSellerAddressDomain() = SellerAddress(
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

fun SellerAddress.toSellerAddressParcelable() = SellerAddressParcelable(
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