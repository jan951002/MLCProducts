package com.jan.melichallenge.config

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

typealias AttributeResponse = com.jan.melichallenge.data.api.response.Attribute
typealias AttributeParcelable = com.jan.melichallenge.ui.product.model.Attribute

typealias InstallmentResponse = com.jan.melichallenge.data.api.response.Installment
typealias InstallmentParcelable = com.jan.melichallenge.ui.product.model.Installment

typealias LocationResponse = com.jan.melichallenge.data.api.response.Location
typealias LocationParcelable = com.jan.melichallenge.ui.product.model.Location

typealias ProductResponse = com.jan.melichallenge.data.api.response.Product
typealias ProductParcelable = com.jan.melichallenge.ui.product.model.Product

typealias RatingsResponse = com.jan.melichallenge.data.api.response.Rating
typealias RatingParcelable = com.jan.melichallenge.ui.product.model.Rating

typealias SearchRoom = com.jan.melichallenge.data.database.model.Search

typealias SellerResponse = com.jan.melichallenge.data.api.response.Seller
typealias SellerParcelable = com.jan.melichallenge.ui.product.model.Seller

typealias SellerAddressResponse = com.jan.melichallenge.data.api.response.SellerAddress
typealias SellerAddressParcelable = com.jan.melichallenge.ui.product.model.SellerAddress

typealias SellerReputationResponse = com.jan.melichallenge.data.api.response.SellerReputation
typealias SellerReputationParcelable = com.jan.melichallenge.ui.product.model.SellerReputation

typealias TransactionsResponse = com.jan.melichallenge.data.api.response.Transactions
typealias TransactionsParcelable = com.jan.melichallenge.ui.product.model.Transactions