package com.jan.melichallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jan.melichallenge.data.database.converter.DataListAttributeConverter
import com.jan.melichallenge.data.database.converter.DataListStringConverter
import com.jan.melichallenge.data.database.dao.ProductDao
import com.jan.melichallenge.data.database.dao.SearchDao
import com.jan.melichallenge.data.database.model.Product
import com.jan.melichallenge.data.database.model.Search
import com.jan.melichallenge.data.database.model.Seller

@Database(
    entities = [Product::class, Search::class, Seller::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataListStringConverter::class, DataListAttributeConverter::class)
abstract class MeliDatabase : RoomDatabase() {

    abstract val productDao: ProductDao
    abstract val searchDao: SearchDao
}