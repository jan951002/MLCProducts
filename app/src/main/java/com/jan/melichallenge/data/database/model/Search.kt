package com.jan.melichallenge.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "searches", indices = [Index(value = ["query"], unique = true)])
data class Search(
    val query: String,
    val time: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id")
    var localId = 0
}