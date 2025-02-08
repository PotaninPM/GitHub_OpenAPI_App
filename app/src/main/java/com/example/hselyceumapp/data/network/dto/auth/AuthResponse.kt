package com.example.hselyceumapp.data.network.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String
)
