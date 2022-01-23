package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Transactions
import com.jan.melichallenge.serializable.TransactionsSerializable

fun TransactionsSerializable.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)

fun Transactions.toTransactionsParcelable() = TransactionsSerializable(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsParcelable(),
    total = this.total
)
