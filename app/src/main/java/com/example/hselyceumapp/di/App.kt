package com.example.hselyceumapp.di

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.hselyceumapp.di.modules.commonModule
import com.example.hselyceumapp.di.modules.networkModule
import com.example.hselyceumapp.di.modules.repositoryModule
import com.example.hselyceumapp.di.modules.roomModule
import com.example.hselyceumapp.di.modules.useCasesModule
import com.example.hselyceumapp.di.modules.viewModelsModule
import com.example.hselyceumapp.domain.state.AuthState
import com.example.hselyceumapp.ui.navigation.AppNavHost
import com.example.hselyceumapp.ui.navigation.Screen
import com.example.hselyceumapp.ui.screens.MainScreen
import com.example.hselyceumapp.ui.viewModels.AuthViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.GlobalContext.startKoin

val appModule = listOf(
    commonModule,
    networkModule,
    repositoryModule,
    roomModule,
    useCasesModule,
    viewModelsModule
)

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
    MainScreen()
}