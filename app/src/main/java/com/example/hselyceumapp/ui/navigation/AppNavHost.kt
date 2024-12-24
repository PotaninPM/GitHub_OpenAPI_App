package com.mikepm.metoo.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.ui.screens.HomeScreen
import com.example.hselyceumapp.ui.screens.MainScreen
import com.example.hselyceumapp.ui.screens.UserScreen
import com.google.gson.Gson

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