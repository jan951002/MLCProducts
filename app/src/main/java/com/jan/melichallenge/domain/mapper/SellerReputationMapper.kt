package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.SellerReputationResponse
import com.jan.melichallenge.domain.model.SellerReputation

fun SellerReputationResponse.toSellerReputationDomain() = SellerReputation(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsDomain()
)