package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.TransactionsParcelable
import com.jan.melichallenge.domain.model.Transactions

fun TransactionsParcelable.toTransactionsDomain() = Transactions(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsDomain(),
    total = this.total
)

fun Transactions.toTransactionsParcelable() = TransactionsParcelable(
    canceled = this.canceled,
    completed = this.completed,
    period = this.period,
    ratings = this.ratings.toRatingsParcelable(),
    total = this.total
)