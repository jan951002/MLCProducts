package com.jan.melichallenge.ui.product.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jan.melichallenge.databinding.ItemAttributeBinding
import com.jan.melichallenge.domain.Attribute
import com.jan.melichallenge.adaptermanager.basicDiffUtil
import com.jan.melichallenge.adaptermanager.inflate

class AttributesAdapter :
    ListAdapter<Attribute, AttributesAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = parent.inflate(ItemAttributeBinding::inflate)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemAttributeBinding: ItemAttributeBinding) :
        RecyclerView.ViewHolder(itemAttributeBinding.root) {

        fun bind(attribute: Attribute) {
            itemAttributeBinding.attribute = attribute
        }
    }

    companion object {
        val diffUtil = basicDiffUtil<Attribute>(
            areContentsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
            areItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        )
    }
}