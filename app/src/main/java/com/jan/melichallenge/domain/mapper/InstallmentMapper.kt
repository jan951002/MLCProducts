package com.jan.melichallenge.domain.mapper

import com.jan.melichallenge.config.InstallmentResponse
import com.jan.melichallenge.domain.Installment

fun InstallmentResponse.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)