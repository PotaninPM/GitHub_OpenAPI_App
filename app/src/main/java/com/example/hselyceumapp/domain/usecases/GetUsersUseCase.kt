package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    suspend operator fun invoke() = repository.getUsers()
}