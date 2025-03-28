package com.example.hselyceumapp.di.modules

import com.example.hselyceumapp.domain.usecases.GetGitHubUsersUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetGitHubUsersUseCase(get(), get()) }
}