package com.example.hselyceumapp.di.modules

import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single { UsersViewModel(get()) }
    single { FavoriteUsersViewModel(get()) }
}