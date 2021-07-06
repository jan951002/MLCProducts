package com.jan.melichallenge.util

import android.content.Context
import android.graphics.Typeface
import android.widget.EditText
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

object TextUtil {
    fun Context.fontRobotoLight(): Typeface? {
        return Typeface.createFromAsset(assets, "Roboto-Light.ttf")
    }

    fun Context.fontRobotoRegular(): Typeface? {
        return Typeface.createFromAsset(assets, "Roboto-Regular.ttf")
    }

    fun String.customCapitalize() = this.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)

    fun EditText.clearFocusAfterDone(action: Int, actionListener: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == action) {
                clearFocus()
                actionListener()
            }
            false
        }
    }

    fun Double.formatPrice(currency: String): String {
        val format = DecimalFormat("#,###")
        format.maximumFractionDigits = 0
        return "$${format.format(this)} $currency"
    }
}