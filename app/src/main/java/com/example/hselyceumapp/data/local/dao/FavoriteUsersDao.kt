package com.example.hselyceumapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hselyceumapp.data.local.entities.FavoriteUsersEntity

@Dao
interface FavoriteUsersDao {
    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteUsersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteUser(user: FavoriteUsersEntity)

    @Delete
    suspend fun removeFavouriteUser(user: FavoriteUsersEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :userId)")
    suspend fun isFavorite(userId: Int): Boolean
}