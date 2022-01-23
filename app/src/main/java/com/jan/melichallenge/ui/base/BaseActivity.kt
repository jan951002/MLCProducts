package com.jan.melichallenge.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

/**
 * Base activity class
 * @author Jaime Trujillo
 */

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseActivity<Binding : ViewBinding>(private val inflate: Inflate<Binding>) :
    AppCompatActivity() {

    private lateinit var _binding: Binding
    protected val binding get() = _binding

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.inflate(layoutInflater, layoutRes(), null, false)
        setContentView(_binding.root)
    }
}
