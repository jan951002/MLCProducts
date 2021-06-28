package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.TransactionsResponse
import com.jan.milichallenge.config.TransactionsRoom
import com.jan.milichallenge.domain.model.Transactions

fun TransactionsResponse.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)

fun TransactionsRoom.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.transactionPeriod,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)

fun Transactions.toTransactionsRoom() = TransactionsRoom(
    canceled = this.canceled,
    completed = this.completed,
    transactionPeriod = this.period,
    ratings = this.ratings.toRatingsRoom(),
    total = this.total
)