package com.jan.melichallenge.data.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataListStringConverter {

    @TypeConverter
    fun fromListString(list: List<String>?): String? {
        list?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<String>?>() {}.type
            return gson.toJson(list, type)
        } ?: run { return null }
    }

    @TypeConverter
    fun toListString(listString: String?): List<String>? {

        listString?.let {
            val gson = Gson()
            val type: Type = object : TypeToken<List<String>?>() {}.type
            return gson.fromJson<List<String>>(listString, type)
        } ?: run {
            return null
        }

    }
}