package com.jan.milichallenge.domain.mapper

import com.jan.milichallenge.config.InstallmentResponse
import com.jan.milichallenge.config.InstallmentRoom
import com.jan.milichallenge.domain.model.Installment

fun InstallmentResponse.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)

fun InstallmentRoom.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.installmentCurrencyId,
    quantity = this.quantity,
    rate = this.installmentRate
)

fun Installment.toInstallmentRoom() = InstallmentRoom(
    amount = this.amount,
    installmentCurrencyId = this.currencyId,
    quantity = this.quantity,
    installmentRate = this.rate
)