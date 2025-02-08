package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.room.entities.FavoriteUserEntity
import com.example.hselyceumapp.domain.model.GitHubUser

fun FavoriteUserEntity.toUser() = GitHubUser(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)