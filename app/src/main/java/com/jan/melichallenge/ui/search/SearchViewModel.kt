package com.jan.melichallenge.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.jan.melichallenge.usecases.SearchListUseCase

class SearchViewModel(application: Application, searchListUseCase: SearchListUseCase) :
    AndroidViewModel(application) {

    val lastSearches = searchListUseCase.invoke().asLiveData()
}