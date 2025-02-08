package com.example.hselyceumapp.data.repository

import android.content.SharedPreferences
import com.example.hselyceumapp.data.mappers.toDomainUser
import com.example.hselyceumapp.data.network.api.AuthApi
import com.example.hselyceumapp.data.network.dto.auth.LoginRequestDto
import com.example.hselyceumapp.data.network.dto.auth.RegisterRequestDto
import com.example.hselyceumapp.domain.model.UserProfile
import com.example.hselyceumapp.domain.model.auth.AuthResponse
import com.example.hselyceumapp.domain.model.auth.LoginRequest
import com.example.hselyceumapp.domain.model.auth.RegisterRequest
import com.example.hselyceumapp.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences
) : AuthRepository {
    override suspend fun register(email: String, password: String): Boolean {
        val response = api.register(RegisterRequestDto(email, password))
        return handleAuthResponse(response)
    }

    override suspend fun login(email: String, password: String): Boolean {
        val response = api.login(LoginRequestDto(email, password))
        return handleAuthResponse(response)
    }

    private fun handleAuthResponse(response: AuthResponse): Boolean {
        saveToken(response.token)
        return true
    }

    override fun saveToken(token: String) {
        prefs.edit().putString("jwt_token", token).apply()
    }

    override fun getToken(): String? {
        return prefs.getString("jwt_token", null)
    }

    override fun clearToken() {
        prefs.edit().remove("jwt_token").apply()
    }
}

