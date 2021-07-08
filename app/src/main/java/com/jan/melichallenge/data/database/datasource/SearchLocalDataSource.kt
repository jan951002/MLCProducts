package com.jan.melichallenge.data.database.datasource

import com.jan.melichallenge.data.database.dao.SearchDao
import com.jan.melichallenge.data.database.mapper.toSearchDomain
import com.jan.melichallenge.data.database.mapper.toSearchRoom
import com.jan.melichallenge.data.search.SearchLocalDataSource
import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.map

class SearchLocalDataSourceImpl(private val searchDao: SearchDao) : SearchLocalDataSource {

    override suspend fun save(search: Search) {
        searchDao.save(search.toSearchRoom())
    }

    override fun getLastSearches() =
        searchDao.getLastSearches().map { searches -> searches.map { it.toSearchDomain() } }
}