package com.jan.melichallenge.databasemanager.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 *  This contains the query operations for search entity using room library
 *  @author Jaime Trujillo
 */
@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(search: Search)

    @Query("SELECT * FROM searches ORDER BY time DESC")
    fun getLastSearches(): Flow<List<Search>>
}
