package com.jan.melichallenge.usecase

import com.jan.melichallenge.domain.repository.SearchRepository

class SaveSearchUseCase(private val searchRepository: SearchRepository) {

    suspend fun invoke(query: String) {
        searchRepository.save(query)
    }
}