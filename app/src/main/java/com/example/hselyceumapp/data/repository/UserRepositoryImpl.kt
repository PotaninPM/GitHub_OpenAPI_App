package com.example.hselyceumapp.data.repository

import com.example.hselyceumapp.data.local.UserDao
import com.example.hselyceumapp.data.mappers.toDomain
import com.example.hselyceumapp.data.mappers.toEntity
import com.example.hselyceumapp.data.network.api.UserApi
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }
}