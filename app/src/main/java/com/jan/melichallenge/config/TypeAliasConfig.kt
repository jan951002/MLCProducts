package com.jan.melichallenge.config

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

typealias AttributeParcelable = com.jan.melichallenge.ui.product.model.Attribute
typealias InstallmentParcelable = com.jan.melichallenge.ui.product.model.Installment
typealias LocationParcelable = com.jan.melichallenge.ui.product.model.Location
typealias ProductParcelable = com.jan.melichallenge.ui.product.model.Product
typealias RatingParcelable = com.jan.melichallenge.ui.product.model.Rating
typealias SellerParcelable = com.jan.melichallenge.ui.product.model.Seller
typealias SellerAddressParcelable = com.jan.melichallenge.ui.product.model.SellerAddress
typealias SellerReputationParcelable = com.jan.melichallenge.ui.product.model.SellerReputation
typealias TransactionsParcelable = com.jan.melichallenge.ui.product.model.Transactions