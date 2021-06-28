package com.jan.milichallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jan.milichallenge.data.database.converter.DataListAttributeConverter
import com.jan.milichallenge.data.database.converter.DataListStringConverter
import com.jan.milichallenge.data.database.dao.ProductDao
import com.jan.milichallenge.data.database.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
@TypeConverters(DataListStringConverter::class, DataListAttributeConverter::class)
abstract class MeliDatabase : RoomDatabase() {

    abstract val productDao: ProductDao
}