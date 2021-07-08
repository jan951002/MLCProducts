package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Transactions

fun com.jan.melichallenge.data.api.response.Transactions.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)