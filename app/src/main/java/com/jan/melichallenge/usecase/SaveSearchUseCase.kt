package com.jan.melichallenge.usecase

import com.jan.melichallenge.data.search.SearchRepository

class SaveSearchUseCase(private val searchRepository: SearchRepository) {

    suspend fun invoke(query: String) {
        searchRepository.save(query)
    }
}