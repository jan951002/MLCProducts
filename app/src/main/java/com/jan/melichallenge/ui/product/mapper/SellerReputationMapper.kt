package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.SellerReputationParcelable
import com.jan.melichallenge.domain.SellerReputation

fun SellerReputationParcelable.toSellerReputationDomain() = SellerReputation(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsDomain()
)

fun SellerReputation.toSellerReputationParcelable() = SellerReputationParcelable(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsParcelable()
)