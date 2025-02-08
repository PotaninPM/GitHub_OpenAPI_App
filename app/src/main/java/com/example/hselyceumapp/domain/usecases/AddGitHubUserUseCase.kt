package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.domain.model.GitHubUser
import com.example.hselyceumapp.domain.repository.GitHubUserRepository

class AddGitHubUserUseCase(private val repository: GitHubUserRepository) {
    suspend operator fun invoke(user: GitHubUser) = repository.addUser(user)
}