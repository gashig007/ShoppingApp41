package com.example.helper.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.helper.data.model.ShopItemDBModel

@Database(entities = [ShopItemDBModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun shopItemDao(): ShopItemDao
}