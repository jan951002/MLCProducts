package com.jan.melichallenge.data.database.datasource

import com.jan.melichallenge.data.database.dao.SearchDao
import com.jan.melichallenge.domain.mapper.toSearchDomain
import com.jan.melichallenge.domain.mapper.toSearchRoom
import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface SearchLocalDataSource {

    suspend fun save(search: Search)

    fun getLastSearches(): Flow<List<Search>>
}

class SearchLocalDataSourceImpl(private val searchDao: SearchDao) : SearchLocalDataSource {

    override suspend fun save(search: Search) {
        searchDao.save(search.toSearchRoom())
    }

    override fun getLastSearches() =
        searchDao.getLastSearches().map { searches -> searches.map { it.toSearchDomain() } }
}