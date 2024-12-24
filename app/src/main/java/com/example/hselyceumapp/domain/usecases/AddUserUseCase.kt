package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.domain.repository.UserRepository

class AddUserUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.addUser(user)
}