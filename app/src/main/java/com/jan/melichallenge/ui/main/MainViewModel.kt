package com.jan.melichallenge.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.jan.melichallenge.domain.repository.SearchRepository

class MainViewModel(application: Application, searchRepository: SearchRepository) :
    AndroidViewModel(application) {

    val lastSearches = searchRepository.getLastSearches().asLiveData()
}