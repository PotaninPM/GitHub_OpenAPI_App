package com.example.hselyceumapp.di.modules

import androidx.room.Room
import com.example.hselyceumapp.data.room.AppDatabase
import com.example.hselyceumapp.data.room.migrations.MIGRATION_1_2
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "users"
        ).addMigrations(MIGRATION_1_2).build()
    }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().favoriteDao() }
}