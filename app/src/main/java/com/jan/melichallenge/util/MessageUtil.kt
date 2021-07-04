package com.jan.melichallenge.util

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

object MessageUtil {

    fun Context.showShortToastWithoutAction(type: ToastyType, message: String) {
        when (type) {
            ToastyType.SUCCESS -> Toasty.success(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.ERROR -> Toasty.error(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.WARNING -> Toasty.warning(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.INFO -> Toasty.info(this, message, Toast.LENGTH_LONG, true).show()
        }
    }
}