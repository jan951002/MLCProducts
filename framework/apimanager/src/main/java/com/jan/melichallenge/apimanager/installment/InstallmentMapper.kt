package com.jan.melichallenge.apimanager.installment

import com.jan.melichallenge.domain.Installment

fun com.jan.melichallenge.apimanager.installment.Installment.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)
