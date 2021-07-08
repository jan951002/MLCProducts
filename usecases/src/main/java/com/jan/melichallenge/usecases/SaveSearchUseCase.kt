package com.jan.melichallenge.usecases

import com.jan.melichallenge.data.search.SearchRepository

class SaveSearchUseCase(private val searchRepository: SearchRepository) {

    suspend fun invoke(query: String) {
        searchRepository.save(query)
    }
}