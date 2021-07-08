package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.SellerReputation

fun com.jan.melichallenge.data.api.response.SellerReputation.toSellerReputationDomain() =
    SellerReputation(
        levelId = this.levelId,
        transactions = this.transactions.toTransactionsDomain()
    )