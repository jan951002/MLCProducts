package com.jan.melichallenge.base

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.jan.melichallenge.R
import com.jan.melichallenge.config.Inflate

abstract class BaseBottomDialog<Binding : ViewBinding>(
    private val inflate: Inflate<Binding>, context: Context
) : Dialog(context) {

    private lateinit var _binding: Binding
    protected val binding get() = _binding

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dialog(context, R.style.ThemeTransparent)

        _binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes(), null, false)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        setContentView(_binding.root)
        window?.attributes?.windowAnimations = R.style.BottomDialogAnimation
        window?.attributes?.gravity = Gravity.BOTTOM
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
    }
}