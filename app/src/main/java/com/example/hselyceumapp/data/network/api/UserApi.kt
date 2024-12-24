package com.example.hselyceumapp.data.network.api

import com.example.hselyceumapp.data.network.dto.UserDto
import retrofit2.http.GET

interface UserApi {

    @GET("/users?since=0&per_page=30")
    suspend fun getUsers(): List<UserDto>
}