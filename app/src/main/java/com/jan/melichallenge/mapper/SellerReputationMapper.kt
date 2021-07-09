package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.SellerReputation
import com.jan.melichallenge.serializable.SellerReputationSerializable

fun SellerReputationSerializable.toSellerReputationDomain() = SellerReputation(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsDomain()
)

fun SellerReputation.toSellerReputationParcelable() = SellerReputationSerializable(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsParcelable()
)