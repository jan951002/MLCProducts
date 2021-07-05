package com.jan.melichallenge.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jan.melichallenge.data.database.model.Search
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(search: Search)

    @Query("SELECT * FROM searches ORDER BY time DESC")
    fun getLastSearches(): Flow<List<Search>>
}