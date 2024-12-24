package com.example.hselyceumapp.ui.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main_screen")

    data object HomeScreen : Screen("home_screen")
    data object UserScreen : Screen("user_screen")
}