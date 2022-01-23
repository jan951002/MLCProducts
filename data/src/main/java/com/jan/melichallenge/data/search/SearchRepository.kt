package com.jan.melichallenge.data.search

import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.Flow
import java.util.*

interface SearchRepository {

    fun getLastSearches(): Flow<List<Search>>

    suspend fun save(query: String)
}

class SearchRepositoryImpl(private val searchLocalDataSource: SearchLocalDataSource) :
    SearchRepository {

    override fun getLastSearches(): Flow<List<Search>> = searchLocalDataSource.getLastSearches()

    override suspend fun save(query: String) {
        searchLocalDataSource.save(Search(0, query, Date().time))
    }
}
