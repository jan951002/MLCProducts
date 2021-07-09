package com.jan.melichallenge.databasemanager.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(search: Search)

    @Query("SELECT * FROM searches ORDER BY time DESC")
    fun getLastSearches(): Flow<List<Search>>
}