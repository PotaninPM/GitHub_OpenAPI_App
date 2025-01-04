package com.example.hselyceumapp.data.network.api

import com.example.hselyceumapp.data.network.dto.UserProfileDto
import com.example.hselyceumapp.data.network.dto.auth.LoginRequestDto
import com.example.hselyceumapp.data.network.dto.auth.RegisterRequestDto
import com.example.hselyceumapp.domain.model.auth.AuthResponse
import com.example.hselyceumapp.domain.model.auth.LoginRequest
import com.example.hselyceumapp.domain.model.auth.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequestDto): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestDto): AuthResponse

    @GET("user/profile")
    suspend fun getProfile(): UserProfileDto
}