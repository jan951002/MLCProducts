package com.jan.melichallenge.domain.repository

import com.jan.melichallenge.data.database.datasource.SearchLocalDataSource
import com.jan.melichallenge.domain.model.Search
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getLastSearches(): Flow<List<Search>>
}

class SearchRepositoryImpl(private val searchLocalDataSource: SearchLocalDataSource) :
    SearchRepository {

    override fun getLastSearches(): Flow<List<Search>> = searchLocalDataSource.getLastSearches()
}