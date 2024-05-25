package com.atakanemre.Ecommerce.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atakanemre.Ecommerce.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 2)
abstract class ProductRoomDB : RoomDatabase() {

    abstract fun productDao(): ProductDao
}