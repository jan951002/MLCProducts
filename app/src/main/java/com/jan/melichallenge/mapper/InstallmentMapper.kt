package com.jan.melichallenge.mapper

import com.jan.melichallenge.domain.Installment
import com.jan.melichallenge.serializable.InstallmentSerializable

fun InstallmentSerializable.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)

fun Installment.toInstallmentParcelable() = InstallmentSerializable(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)