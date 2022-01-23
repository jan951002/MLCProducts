package com.jan.melichallenge.ui.custom.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView
import com.jan.melichallenge.textmanager.fontFromAsset

private const val ROBOTO_REGULAR_FONT = "Roboto-Regular.ttf"

/**
 * Custom Textview with roboto regular font
 * @author Jaime Trujillo
 */
class RobotoRegularTextView : MaterialTextView {

    constructor(context: Context) : super(context) {
        context.let { this.typeface = it.fontFromAsset(ROBOTO_REGULAR_FONT) }
    }

    constructor(
        context: Context, attrs: AttributeSet?
    ) : super(context, attrs) {
        context.let { this.typeface = it.fontFromAsset(ROBOTO_REGULAR_FONT) }
    }

    constructor(
        context: Context, attrs: AttributeSet?, defStyle: Int
    ) : super(context, attrs, defStyle) {
        context.let { this.typeface = it.fontFromAsset(ROBOTO_REGULAR_FONT) }
    }
}
