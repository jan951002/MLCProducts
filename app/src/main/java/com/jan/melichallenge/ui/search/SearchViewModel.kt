package com.jan.melichallenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jan.melichallenge.usecases.search.SearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(searchListUseCase: SearchListUseCase) : ViewModel() {

    val lastSearches = searchListUseCase.invoke().asLiveData()
}