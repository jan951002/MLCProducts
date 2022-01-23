package com.jan.melichallenge.ui.product.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jan.melichallenge.adaptermanager.basicDiffUtil
import com.jan.melichallenge.adaptermanager.inflate
import com.jan.melichallenge.databinding.ItemProductBinding
import com.jan.melichallenge.domain.Product

class ProductsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Product, ProductsAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = parent.inflate(ItemProductBinding::inflate)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {

        fun bind(product: Product) {
            itemProductBinding.product = product
            itemView.setOnClickListener { listener.onItemClick(product) }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(product: Product)
    }

    companion object {
        val diffUtil = basicDiffUtil<Product>(
            areContentsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
            areItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        )
    }
}