package com.jan.melichallenge.config

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

typealias AttributeResponse = com.jan.melichallenge.data.api.response.Attribute

typealias InstallmentResponse = com.jan.melichallenge.data.api.response.Installment

typealias LocationResponse = com.jan.melichallenge.data.api.response.Location

typealias ProductResponse = com.jan.melichallenge.data.api.response.Product

typealias RatingsResponse = com.jan.melichallenge.data.api.response.Rating

typealias SearchRoom = com.jan.melichallenge.data.database.model.Search

typealias SellerResponse = com.jan.melichallenge.data.api.response.Seller

typealias SellerAddressResponse = com.jan.melichallenge.data.api.response.SellerAddress

typealias SellerReputationResponse = com.jan.melichallenge.data.api.response.SellerReputation

typealias TransactionsResponse = com.jan.melichallenge.data.api.response.Transactions
