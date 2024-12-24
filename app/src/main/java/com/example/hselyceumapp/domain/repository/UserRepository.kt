package com.example.hselyceumapp.domain.repository

import com.example.hselyceumapp.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun addUser(user: User)
}