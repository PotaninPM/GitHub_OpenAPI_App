package com.example.hselyceumapp.di

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.room.Room
import com.example.hselyceumapp.data.room.AppDatabase
import com.example.hselyceumapp.data.network.api.UserApi
import com.example.hselyceumapp.data.repository.UserRepositoryImpl
import com.example.hselyceumapp.data.room.migrations.MIGRATION_1_2
import com.example.hselyceumapp.domain.repository.UserRepository
import com.example.hselyceumapp.domain.usecases.AddUserUseCase
import com.example.hselyceumapp.domain.usecases.GetUsersUseCase
import com.example.hselyceumapp.ui.screens.MainScreen
import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}

@Composable
fun App() {
    KoinContext {
        MainScreen()
    }
}

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "users"
        ).addMigrations(MIGRATION_1_2).build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().favoriteDao() }

    single<UserRepository> { UserRepositoryImpl(get()) }

    single { GetUsersUseCase(get(), get()) }
    single { AddUserUseCase(get()) }

    single { UsersViewModel(get(), get()) }

    single {
        FavoriteUsersViewModel(get())
    }
}