package com.jan.melichallenge.apimanager.seller.reputation

import com.jan.melichallenge.apimanager.transactions.toTransactionsDomain
import com.jan.melichallenge.domain.SellerReputation

fun com.jan.melichallenge.apimanager.seller.reputation.SellerReputation.toSellerReputationDomain() =
    SellerReputation(
        levelId = this.levelId,
        transactions = this.transactions.toTransactionsDomain()
    )