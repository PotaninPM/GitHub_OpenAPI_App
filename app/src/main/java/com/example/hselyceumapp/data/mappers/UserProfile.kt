package com.example.hselyceumapp.data.mappers

import com.example.hselyceumapp.data.network.dto.UserProfileDto
import com.example.hselyceumapp.domain.model.UserProfile

fun UserProfileDto.toDomainUser(): UserProfile {
    return UserProfile(
        email = this.email
    )
}
