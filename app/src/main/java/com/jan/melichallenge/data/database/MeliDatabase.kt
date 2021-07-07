package com.jan.melichallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jan.melichallenge.data.database.dao.SearchDao
import com.jan.melichallenge.data.database.model.Search

@Database(
    entities = [Search::class],
    version = 1,
    exportSchema = false
)
abstract class MeliDatabase : RoomDatabase() {

    abstract val searchDao: SearchDao
}