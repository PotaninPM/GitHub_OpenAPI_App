package com.example.hselyceumapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    @ColumnInfo(name = "is_favorite") val isFavorite: Int = 0
)
