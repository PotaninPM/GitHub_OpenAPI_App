package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.room.entities.UserEntity
import com.example.hselyceumapp.data.network.dto.GitHubUserDto
import com.example.hselyceumapp.domain.model.GitHubUser

fun GitHubUserDto.toEntity() = UserEntity(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)

fun GitHubUserDto.toDomain() = GitHubUser(
    id = id,
    login = login,
    avatarUrl = avatarUrl,
    htmlUrl = htmlUrl
)

fun GitHubUser.toUserEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl
    )
}

fun UserEntity.toUser(): GitHubUser {
    return GitHubUser(
        id = this.id,
        login = this.login,
        avatarUrl = this.avatarUrl,
        htmlUrl = this.htmlUrl
    )
}