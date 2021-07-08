package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.TransactionsResponse
import com.jan.melichallenge.domain.Transactions

fun TransactionsResponse.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)