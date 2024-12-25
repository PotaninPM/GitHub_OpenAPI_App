package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.room.entities.FavoriteUserEntity
import com.example.hselyceumapp.domain.model.User

fun FavoriteUserEntity.toeUser() = User(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)