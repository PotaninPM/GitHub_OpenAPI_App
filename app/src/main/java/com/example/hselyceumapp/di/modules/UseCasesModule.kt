package com.example.hselyceumapp.di.modules

import com.example.hselyceumapp.domain.usecases.GetGitHubUsersUseCase
import com.example.hselyceumapp.domain.usecases.auth.LoginUseCase
import com.example.hselyceumapp.domain.usecases.auth.LogoutUseCase
import com.example.hselyceumapp.domain.usecases.auth.RegisterUseCase
import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.dsl.module

val useCasesModule = module {
    single { GetGitHubUsersUseCase(get(), get()) }
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
    single { LogoutUseCase(get()) }
}