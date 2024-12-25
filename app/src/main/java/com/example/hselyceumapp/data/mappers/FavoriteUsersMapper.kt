package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.local.entities.FavoriteUsersEntity
import com.example.hselyceumapp.domain.model.User

fun User.toFavoriteEntity(): FavoriteUsersEntity = FavoriteUsersEntity(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)

fun FavoriteUsersEntity.toDomain(): User = User(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)