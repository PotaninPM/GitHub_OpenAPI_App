package com.example.hselyceumapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hselyceumapp.data.local.dao.FavoriteUsersDao
import com.example.hselyceumapp.data.local.dao.UserDao
import com.example.hselyceumapp.data.local.entities.FavoriteUsersEntity
import com.example.hselyceumapp.data.local.entities.UserEntity

@Database(entities = [UserEntity::class, FavoriteUsersEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteUsersDao(): FavoriteUsersDao
    abstract fun userDao(): UserDao
}