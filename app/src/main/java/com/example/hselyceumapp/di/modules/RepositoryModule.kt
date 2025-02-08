package com.example.hselyceumapp.di.modules

import com.example.hselyceumapp.data.repository.AuthRepositoryImpl
import com.example.hselyceumapp.data.repository.GitHubUserRepositoryImpl
import com.example.hselyceumapp.domain.repository.AuthRepository
import com.example.hselyceumapp.domain.repository.GitHubUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<GitHubUserRepository> { GitHubUserRepositoryImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}