package com.example.hselyceumapp.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hselyceumapp.data.room.entities.FavoriteUserEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(user: FavoriteUserEntity)

    @Delete
    suspend fun deleteFavorite(user: FavoriteUserEntity)

    @Query("SELECT * FROM favorites")
    suspend fun getFavoriteUsers(): List<FavoriteUserEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :id)")
    suspend fun isUserFavorite(id: Int): Boolean
}