package com.jan.melichallenge.databasemanager.search

import com.jan.melichallenge.data.search.SearchLocalDataSource
import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.map

/**
 *  Class to implement SearchLocalDataSource interface
 *  @author Jaime Trujillo
 */
class SearchLocalDataSourceImpl(private val searchDao: SearchDao) : SearchLocalDataSource {

    override suspend fun save(search: Search) {
        searchDao.save(search.toSearchRoom())
    }

    override fun getLastSearches() = searchDao.getLastSearches().map { searches ->
        searches.map { it.toSearchDomain() }
    }
}
