package com.example.hselyceumapp.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hselyceumapp.ui.screens.HomeScreen
import com.example.hselyceumapp.ui.screens.MainScreen
import com.example.hselyceumapp.ui.screens.UserScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen()
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable("user_screen") {
            UserScreen()
        }
    }
}