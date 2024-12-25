package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.local.entities.UserEntity
import com.example.hselyceumapp.data.network.dto.UserDto
import com.example.hselyceumapp.domain.model.User

fun UserDto.toEntity() = UserEntity(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)

fun UserDto.toDomain() = User(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl,
    is_favorite = 0
)

fun UserEntity.toUser(): User {
    return User(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl,
        is_favorite = this.isFavorite
    )
}