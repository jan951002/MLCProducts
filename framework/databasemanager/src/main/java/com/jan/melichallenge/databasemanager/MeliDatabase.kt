package com.jan.melichallenge.databasemanager

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jan.melichallenge.databasemanager.search.Search
import com.jan.melichallenge.databasemanager.search.SearchDao

@Database(
    entities = [Search::class],
    version = 1,
    exportSchema = false
)
abstract class MeliDatabase : RoomDatabase() {

    abstract val searchDao: SearchDao
}

/**
 *  function to build our MeliDatabase
 *  @param application
 */
fun provideMeliDatabase(application: Application): MeliDatabase =
    Room.databaseBuilder(application, MeliDatabase::class.java, "meli-db")
        .fallbackToDestructiveMigration()
        .build()