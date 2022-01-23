package com.jan.melichallenge.adaptermanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

/**
 * Function to build our generic basic diff util for ListAdapter (RecyclerView)
 * @param areContentsTheSame Function to validate contents
 * @param areItemsTheSame Function to validate items
 * @author Jaime Trujillo
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
 * @param inflate To inflate a ViewGroup
 * @author Jaime Trujillo
 */
fun <Binding : ViewBinding> ViewGroup.inflate(inflate: Inflate<Binding>): Binding {
    val layoutInflater = LayoutInflater.from(context)
    return inflate(layoutInflater, this, false)
}

private typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T