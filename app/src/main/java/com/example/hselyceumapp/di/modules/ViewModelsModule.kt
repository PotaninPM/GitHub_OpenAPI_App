package com.example.hselyceumapp.di.modules

import android.util.Log
import com.example.hselyceumapp.ui.viewModels.AuthViewModel
import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single { UsersViewModel(get()) }
    single { FavoriteUsersViewModel(get()) }
    single { AuthViewModel(get(), get(), get()) }
}