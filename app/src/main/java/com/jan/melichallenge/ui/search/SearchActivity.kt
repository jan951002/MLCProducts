package com.jan.melichallenge.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import com.jan.melichallenge.R
import com.jan.melichallenge.databinding.ActivitySearchBinding
import com.jan.melichallenge.domain.Search
import com.jan.melichallenge.textmanager.TextExtension.clearFocusAfterDone
import com.jan.melichallenge.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity :
    BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate),
    SearchSuggestionsAdapter.OnItemClickListener {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchSuggestionsAdapter: SearchSuggestionsAdapter

    override fun layoutRes(): Int = R.layout.activity_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding.searchEdit.requestFocus()) {
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
        searchSuggestionsAdapter = SearchSuggestionsAdapter(this)
        binding.searchSuggestionsRecycler.adapter = searchSuggestionsAdapter
        binding.searchBackImage.setOnClickListener { onBackPressed() }
        binding.searchEdit.clearFocusAfterDone(EditorInfo.IME_ACTION_SEARCH) { search() }
        observableViewModel()
    }

    private fun observableViewModel() {
        searchViewModel.lastSearches.observe(this, { searchSuggestions ->
            searchSuggestionsAdapter.submitList(searchSuggestions)
        })
    }

    override fun onAutocompleteText(search: Search) {
        binding.searchEdit.setText(search.query)
        binding.searchEdit.setSelection(binding.searchEdit.text.toString().length)
    }

    override fun onSelectText(search: Search) {
        binding.searchEdit.setText(search.query)
        search()
    }

    private fun search() {
        val intent = Intent().apply {
            putExtra("query", binding.searchEdit.text.toString())
        }
        setResult(RESULT_OK, intent)
        finish()
    }

}