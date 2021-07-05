package com.jan.melichallenge.ui.search

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jan.melichallenge.databinding.ItemSearchSuggestionBinding
import com.jan.melichallenge.domain.model.Search
import com.jan.melichallenge.util.AdapterUtil
import com.jan.melichallenge.util.AdapterUtil.inflate

class SearchSuggestionsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Search, SearchSuggestionsAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = parent.inflate(ItemSearchSuggestionBinding::inflate)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemSearchSuggestionBinding: ItemSearchSuggestionBinding) :
        RecyclerView.ViewHolder(itemSearchSuggestionBinding.root) {

        private val binding = itemSearchSuggestionBinding

        fun bind(search: Search) {
            binding.search = search
            binding.searchAutocompleteImage.setOnClickListener { listener.onAutocompleteText(search) }
            itemView.setOnClickListener { listener.onSelectText(search) }
        }
    }

    interface OnItemClickListener {

        fun onAutocompleteText(search: Search)
        fun onSelectText(search: Search)
    }

    companion object {
        val diffUtil = AdapterUtil.basicDiffUtil<Search>(
            areContentsTheSame = { oldItem, newItem -> oldItem.localId == newItem.localId },
            areItemsTheSame = { oldItem, newItem -> oldItem == newItem },
        )
    }
}

