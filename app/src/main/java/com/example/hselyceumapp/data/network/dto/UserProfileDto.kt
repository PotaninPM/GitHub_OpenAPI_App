package com.example.hselyceumapp.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDto(
    val id: Int,
    val avatar: String,
    val email: String,
    val name: String
)
