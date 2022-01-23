package com.jan.melichallenge.apimanager.transactions

import com.jan.melichallenge.apimanager.raiting.toRatingsDomain
import com.jan.melichallenge.domain.Transactions

fun com.jan.melichallenge.apimanager.transactions.Transactions.toTransactionsDomain() =
    Transactions(
        canceled = this.canceled,
        completed = this.completed,
        period = this.period,
        ratings = this.ratings.toRatingsDomain(),
        total = this.total
    )
