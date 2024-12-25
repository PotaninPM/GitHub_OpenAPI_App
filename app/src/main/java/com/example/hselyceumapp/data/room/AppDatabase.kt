package com.example.hselyceumapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hselyceumapp.data.room.dao.FavoriteDao
import com.example.hselyceumapp.data.room.dao.UserDao
import com.example.hselyceumapp.data.room.entities.FavoriteUserEntity
import com.example.hselyceumapp.data.room.entities.UserEntity

@Database(entities = [UserEntity::class, FavoriteUserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun favoriteDao(): FavoriteDao
}