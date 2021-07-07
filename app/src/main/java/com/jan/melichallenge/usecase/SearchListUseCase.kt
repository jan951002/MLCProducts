package com.jan.melichallenge.usecase

import com.jan.melichallenge.domain.repository.SearchRepository

class SearchListUseCase(private val searchRepository: SearchRepository) {

    fun invoke() = searchRepository.getLastSearches()
}