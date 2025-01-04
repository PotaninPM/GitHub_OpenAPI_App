package com.example.hselyceumapp.domain.usecases

import android.util.Log
import com.example.hselyceumapp.data.room.dao.UserDao
import com.example.hselyceumapp.data.mappers.toDomain
import com.example.hselyceumapp.data.mappers.toEntity
import com.example.hselyceumapp.data.mappers.toUser
import com.example.hselyceumapp.data.network.api.GitHubUserApi
import com.example.hselyceumapp.domain.model.GitHubUser

class GetGitHubUsersUseCase(
    private val userApi: GitHubUserApi,
    private val userDao: UserDao
) {
    suspend operator fun invoke(since: String? = null): List<GitHubUser> {
        return try {
            val usersFromApi = userApi.getUsers(since)

            userDao.insertUsers(usersFromApi.map { it.toEntity() })

            usersFromApi.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("GetGitHubUsersUseCase", "Ошибка при загрузке данных: $e")
            userDao.getAllUsers().map { it.toUser() }
        }
    }
}