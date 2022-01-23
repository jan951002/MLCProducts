package com.jan.melichallenge.textmanager

import android.content.Context
import android.graphics.Typeface
import android.widget.EditText
import java.text.DecimalFormat

private const val PATTERN_PRICE = "#,###"

/**
 * Function to create a text font from an asset
 * @param fontAssetName Name of the asset
 * @author Jaime Trujillo
 */
fun Context.fontFromAsset(fontAssetName: String): Typeface? = Typeface.createFromAsset(
    assets, fontAssetName
)

/**
 * Function to clear the focus of an EditText
 * @param action Action to clear focus
 * @param actionListener Function to run after clear focus
 * @author Jaime Trujillo
 */
fun EditText.clearFocusAfterDone(action: Int, actionListener: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == action) {
            clearFocus()
            actionListener()
        }
        false
    }
}

/**
 * Function to apply currency formatting of a double value
 * @param currency Currency to apply
 * @author Jaime Trujillo
 */
fun Double.formatPrice(currency: String): String {
    val format = DecimalFormat(PATTERN_PRICE).apply { maximumFractionDigits = 0 }
    return "$${format.format(this)} $currency"
}
