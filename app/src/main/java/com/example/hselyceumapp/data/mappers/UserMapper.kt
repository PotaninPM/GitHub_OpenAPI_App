package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.room.entities.UserEntity
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
    htmlUrl = htmlUrl
)

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl
    )
}