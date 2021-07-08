package com.jan.melichallenge.textmanager

import android.content.Context
import android.graphics.Typeface
import android.widget.EditText
import java.text.DecimalFormat

object TextExtension {

    fun Context.fontFromAsset(fontAssetName: String): Typeface? {
        return Typeface.createFromAsset(assets, fontAssetName)
    }

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