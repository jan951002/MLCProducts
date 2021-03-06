package com.jan.melichallenge.usecases.search

import com.jan.melichallenge.data.search.SearchRepository

class SearchListUseCase(private val searchRepository: SearchRepository) {

    fun invoke() = searchRepository.getLastSearches()
}
