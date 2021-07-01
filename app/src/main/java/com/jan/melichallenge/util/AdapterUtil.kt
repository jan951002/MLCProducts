package com.jan.melichallenge.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.jan.melichallenge.config.Inflate

/**
 * This object contains the adapter utilities
 * @author Jaime Trujillo
 */
object AdapterUtil {

    /**
     * Function to build our generic basic diff util for ListAdapter (RecyclerView)
     */
    inline fun <T> basicDiffUtil(
        crossinline areContentsTheSame: (T, T) -> Boolean,
        crossinline areItemsTheSame: (T, T) -> Boolean
    ): DiffUtil.ItemCallback<T> = object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T) = areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T) =
            areContentsTheSame(oldItem, newItem)
    }

    /**
     * Function extension of ViewGroup to inflate layout with Databinding
     */
    fun <Binding : ViewBinding> ViewGroup.inflate(inflate: Inflate<Binding>): Binding {
        val layoutInflater = LayoutInflater.from(context)
        return inflate(layoutInflater, this, false)
    }
}