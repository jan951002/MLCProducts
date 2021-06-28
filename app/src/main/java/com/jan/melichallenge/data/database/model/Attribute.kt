package com.jan.melichallenge.data.database.model

import androidx.room.ColumnInfo

data class Attribute(
    @ColumnInfo(name = "attribute_group_id")
    val attributeGroupId: String,

    @ColumnInfo(name = "attribute_group_name")
    val attributeGroupName: String,

    val attributeId: String,

    @ColumnInfo(name = "attribute_name")
    val attributeName: String,

    val source: Int,

    @ColumnInfo(name = "value_id")
    val valueId: String?,

    @ColumnInfo(name = "value_name")
    val valueName: String,
)