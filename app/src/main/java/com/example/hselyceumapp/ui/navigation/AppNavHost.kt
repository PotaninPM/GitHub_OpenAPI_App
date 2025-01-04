package com.example.hselyceumapp.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hselyceumapp.ui.screens.FavScreen
import com.example.hselyceumapp.ui.screens.HomeScreen
import com.example.hselyceumapp.ui.screens.MainScreen
import com.example.hselyceumapp.ui.screens.auth.SignInScreen
import com.example.hselyceumapp.ui.screens.auth.SignUpScreen
import com.example.hselyceumapp.ui.screens.UserScreen
import com.example.hselyceumapp.ui.screens.WelcomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
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

        composable(Screen.UserScreen.route) {
            UserScreen()
        }

        composable(Screen.FavScreen.route) {
            FavScreen(navController)
        }

        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(Screen.SignInScreen.route) {
            SignInScreen(navController)
        }

        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }
    }
}