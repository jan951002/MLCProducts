package com.jan.melichallenge.data.search

import com.jan.melichallenge.domain.Search
import kotlinx.coroutines.flow.Flow

/**
 *  Interface to define the contracts of Search local dataSource
 *  @author Jaime Trujillo
 */
interface SearchLocalDataSource {

    /**
     *  Function to persist a search in our local database
     *  @param search Domain object to convert to a search entity
     *  @author Jaime Trujillo
     */
    suspend fun save(search: Search)

    /**
     *  Function to get the latest searches from our local database
     *  @author Jaime Trujillo
     */
    fun getLastSearches(): Flow<List<Search>>
}
