package com.jan.melichallenge.config

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

typealias AttributeRoom = com.jan.melichallenge.data.database.model.Attribute
typealias AttributeResponse = com.jan.melichallenge.data.api.response.Attribute

typealias InstallmentResponse = com.jan.melichallenge.data.api.response.Installment
typealias InstallmentRoom = com.jan.melichallenge.data.database.model.Installment

typealias ProductResponse = com.jan.melichallenge.data.api.response.Product
typealias ProductRoom = com.jan.melichallenge.data.database.model.Product

typealias RatingsResponse = com.jan.melichallenge.data.api.response.Rating
typealias RatingsRoom = com.jan.melichallenge.data.database.model.Rating

typealias SearchRoom = com.jan.melichallenge.data.database.model.Search

typealias SellerResponse = com.jan.melichallenge.data.api.response.Seller
typealias SellerRoom = com.jan.melichallenge.data.database.model.Seller

typealias SellerAddressResponse = com.jan.melichallenge.data.api.response.SellerAddress
typealias SellerAddressRoom = com.jan.melichallenge.data.database.model.SellerAddress

typealias SellerReputationResponse = com.jan.melichallenge.data.api.response.SellerReputation
typealias SellerReputationRoom = com.jan.melichallenge.data.database.model.SellerReputation

typealias TransactionsResponse = com.jan.melichallenge.data.api.response.Transactions
typealias TransactionsRoom = com.jan.melichallenge.data.database.model.Transactions
