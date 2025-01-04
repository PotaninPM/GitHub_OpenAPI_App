package com.example.hselyceumapp.ui.navigation

sealed class Screen(val route: String) {
    data object WelcomeScreen : Screen("welcome_screen")
    data object MainScreen : Screen("main_screen")

    data object HomeScreen : Screen("home_screen")
    data object UserScreen : Screen("user_screen")
    data object FavScreen : Screen("fav_screen")

    data object SignUpScreen : Screen("sign_up_screen")
    data object SignInScreen : Screen("sign_in_screen")
}