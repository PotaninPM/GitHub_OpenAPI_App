package com.example.hselyceumapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hselyceumapp.data.local.dao.FavoriteDao
import com.example.hselyceumapp.data.local.dao.UserDao
import com.example.hselyceumapp.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun favoriteDao(): FavoriteDao
}