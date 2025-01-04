package com.example.hselyceumapp.data.network.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val email: String,
    val password: String
)
