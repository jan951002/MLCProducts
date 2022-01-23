package com.jan.melichallenge.databasemanager.search

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 *  Entity to represent a search
 *  @author Jaime Trujillo
 */
@Entity(tableName = "searches", indices = [Index(value = ["query"], unique = true)])
data class Search(
    val query: String,
    val time: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id")
    var localId = 0
}