package com.example.hselyceumapp.data.repository

import com.example.hselyceumapp.data.mappers.toDomain
import com.example.hselyceumapp.data.network.api.GitHubUserApi
import com.example.hselyceumapp.domain.model.GitHubUser
import com.example.hselyceumapp.domain.repository.GitHubUserRepository

class GitHubUserRepositoryImpl(
    private val api: GitHubUserApi
) : GitHubUserRepository {
    override suspend fun getUsers(): List<GitHubUser> {
        return api.getUsers().map { it.toDomain() }
    }

    override suspend fun addUser(user: GitHubUser) {
        TODO("Not yet implemented")
    }
}