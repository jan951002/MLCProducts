package com.jan.milichallenge.data.database.model

import androidx.room.ColumnInfo

data class State(

    @ColumnInfo(name = "state_name")
    val stateName: String
)