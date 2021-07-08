package com.jan.melichallenge.ui.product.mapper

import com.jan.melichallenge.config.InstallmentParcelable
import com.jan.melichallenge.domain.Installment

fun InstallmentParcelable.toInstallmentDomain() = Installment(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)

fun Installment.toInstallmentParcelable() = InstallmentParcelable(
    amount = this.amount,
    currencyId = this.currencyId,
    quantity = this.quantity,
    rate = this.rate
)