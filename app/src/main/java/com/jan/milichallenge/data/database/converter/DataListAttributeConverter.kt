package com.jan.milichallenge.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jan.milichallenge.data.database.model.Attribute
import java.lang.reflect.Type

class DataListAttributeConverter {

    @TypeConverter
    fun fromListAttribute(list: List<Attribute>?): String? {
        list?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Attribute>?>() {}.type
            return gson.toJson(list, type)
        } ?: run { return null }
    }

    @TypeConverter
    fun toListAttribute(listString: String?): List<Attribute>? {

        listString?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Attribute>?>() {}.type
            return gson.fromJson<List<Attribute>>(listString, type)
        } ?: run {
            return null
        }

    }
}