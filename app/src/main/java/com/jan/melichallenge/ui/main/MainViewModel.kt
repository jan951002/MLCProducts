package com.jan.melichallenge.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.jan.melichallenge.domain.repository.SearchRepository
import com.jan.melichallenge.usecase.SearchListUseCase

class MainViewModel(application: Application, searchListUseCase: SearchListUseCase) :
    AndroidViewModel(application) {

    val lastSearches = searchListUseCase.invoke().asLiveData()
}