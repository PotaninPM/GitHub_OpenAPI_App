package com.example.hselyceumapp.domain.repository

interface AuthRepository {
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean

    fun saveToken(token: String)
    fun getToken(): String?
    fun clearToken()
}