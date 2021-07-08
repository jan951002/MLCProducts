package com.jan.melichallenge.ui.custom.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView
import com.jan.melichallenge.textmanager.TextExtension.fontFromAsset

class RobotoRegularTextView : MaterialTextView {

    constructor(context: Context) : super(context) {
        context.let { this.typeface = it.fontFromAsset("Roboto-Regular.ttf") }
    }

    constructor(
        context: Context, attrs: AttributeSet?
    ) : super(context, attrs) {
        context.let { this.typeface = it.fontFromAsset("Roboto-Regular.ttf") }
    }

    constructor(
        context: Context, attrs: AttributeSet?, defStyle: Int
    ) : super(context, attrs, defStyle) {
        context.let { this.typeface = it.fontFromAsset("Roboto-Regular.ttf") }
    }
}