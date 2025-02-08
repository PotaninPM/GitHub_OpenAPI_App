package com.example.hselyceumapp.di.modules

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val commonModule = module {
    single {
        androidContext().getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
    }
}