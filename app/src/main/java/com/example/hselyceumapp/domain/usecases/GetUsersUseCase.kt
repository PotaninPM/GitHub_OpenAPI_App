package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.data.local.dao.UserDao
import com.example.hselyceumapp.data.mappers.toDomain
import com.example.hselyceumapp.data.mappers.toEntity
import com.example.hselyceumapp.data.mappers.toUser
import com.example.hselyceumapp.data.network.api.UserApi
import com.example.hselyceumapp.domain.model.User
import kotlinx.coroutines.flow.map

class GetUsersUseCase(
    private val userApi: UserApi,
    private val userDao: UserDao
) {
    suspend operator fun invoke(): List<User> {
        return try {
            val usersFromApi = userApi.getUsers()
            userDao.clearUsers()
            userDao.insertUsers(usersFromApi.map { it.toEntity() })
            usersFromApi.map { it.toDomain() }
        } catch (e: Exception) {
            userDao.getAllUsers().map { it.toUser() }
        }
    }
}