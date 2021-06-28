package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.SellerReputationResponse
import com.jan.milichallenge.config.SellerReputationRoom
import com.jan.milichallenge.domain.model.SellerReputation

fun SellerReputationResponse.toSellerReputationDomain() = SellerReputation(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsDomain()
)

fun SellerReputationRoom.toSellerReputationDomain() = SellerReputation(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsDomain()
)

fun SellerReputation.toSellerReputationRoom() = SellerReputationRoom(
    levelId = this.levelId,
    transactions = this.transactions.toTransactionsRoom()
)