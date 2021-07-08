package com.jan.melichallenge.data.api.mapper

import com.jan.melichallenge.domain.Installment

fun com.jan.melichallenge.data.api.response.Installment.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)