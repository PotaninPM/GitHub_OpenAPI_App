package com.example.hselyceumapp.domain.repository

import com.example.hselyceumapp.domain.model.GitHubUser

interface GitHubUserRepository {
    suspend fun getUsers(): List<GitHubUser>
    suspend fun addUser(user: GitHubUser)
}