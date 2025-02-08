package com.example.hselyceumapp.data.network.api

import com.example.hselyceumapp.data.network.dto.GitHubUserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubUserApi {

    @GET("users")
    suspend fun getUsers(
        @Query("since") since: String? = null,
        @Query("per_page") perPage: Int = 30
    ): List<GitHubUserDto>
}