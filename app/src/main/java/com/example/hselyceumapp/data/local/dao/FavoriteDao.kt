package com.example.hselyceumapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.hselyceumapp.data.local.entities.UserEntity

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM users WHERE is_favorite = 1")
    suspend fun getFavoriteUsers(): List<UserEntity>

    @Query("UPDATE users SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateUserFavoriteStatus(id: Int, isFavorite: Int)
}