package com.jan.melichallenge.ui.custom.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView
import com.jan.melichallenge.util.TextUtil.fontRobotoLight

class RobotoLightTextView : MaterialTextView {

    constructor(context: Context) : super(context) {
        context.let { this.typeface = it.fontRobotoLight() }
    }

    constructor(
        context: Context, attrs: AttributeSet?
    ) : super(context, attrs) {
        context.let { this.typeface = it.fontRobotoLight() }
    }

    constructor(
        context: Context, attrs: AttributeSet?, defStyle: Int
    ) : super(context, attrs, defStyle) {
        context.let { this.typeface = it.fontRobotoLight() }
    }
}