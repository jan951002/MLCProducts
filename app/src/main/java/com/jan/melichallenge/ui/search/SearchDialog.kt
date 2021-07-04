package com.jan.melichallenge.ui.search

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.jan.melichallenge.R
import com.jan.melichallenge.base.BaseBottomDialog
import com.jan.melichallenge.databinding.DialogSearchBinding
import com.jan.melichallenge.domain.model.Search
import com.jan.melichallenge.util.TextUtil.clearFocusAfterDone

class SearchDialog(context: Context, private val onSearchPressed: OnSearchPressed) :
    BaseBottomDialog<DialogSearchBinding>(DialogSearchBinding::inflate, context),
    SearchSuggestionsAdapter.OnItemClickListener {

    var searchSuggestions = listOf<Search>()
    private lateinit var searchSuggestionsAdapter: SearchSuggestionsAdapter

    override fun layoutRes(): Int = R.layout.dialog_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchSuggestionsAdapter = SearchSuggestionsAdapter(this)
        binding.searchBackImage.setOnClickListener { dismiss() }
        binding.searchEdit.clearFocusAfterDone(EditorInfo.IME_ACTION_SEARCH) {
            dismiss()
            onSearchPressed.onSearch(binding.searchEdit.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        searchSuggestionsAdapter.submitList(searchSuggestions)
        binding.searchSuggestionsRecycler.adapter = searchSuggestionsAdapter
    }

    override fun onAutocompleteText(search: Search) {
        binding.searchEdit.setText(search.query)
    }

    interface OnSearchPressed {
        fun onSearch(query: String)
    }
}