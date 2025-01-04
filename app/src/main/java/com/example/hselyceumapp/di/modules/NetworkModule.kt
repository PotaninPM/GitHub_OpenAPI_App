package com.example.hselyceumapp.di.modules

import com.example.hselyceumapp.data.network.api.AuthApi
import com.example.hselyceumapp.data.network.api.GitHubUserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(AuthApi::class.java) }
    single { get<Retrofit>().create(GitHubUserApi::class.java) }
}