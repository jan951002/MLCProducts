package com.jan.melichallenge.data.search

import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.Flow

interface SearchLocalDataSource {

    suspend fun save(search: Search)

    fun getLastSearches(): Flow<List<Search>>
}