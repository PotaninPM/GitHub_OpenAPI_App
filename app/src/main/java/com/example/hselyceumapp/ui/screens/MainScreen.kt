package com.example.hselyceumapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hselyceumapp.R
import com.mikepm.metoo.ui.navigation.AppNavBar
import com.mikepm.metoo.ui.navigation.AppNavHost
import com.mikepm.metoo.ui.navigation.BottomNavItem
import com.mikepm.metoo.ui.navigation.Screen

@Composable
fun MainScreen() {
    val topLevelDestinations = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            labelRes = R.string.main,
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu
        )
//        BottomNavItem(
//            route = Screen..route,
//            labelRes = R.string.event_invitations,
//            selectedIcon = Icons.Filled.AddCircle,
//            unselectedIcon = Icons.Outlined.Add
//        ),
//        BottomNavItem(
//            route = Screen.Profile.route,
//            labelRes = R.string.profile,
//            selectedIcon = Icons.Filled.AccountCircle,
//            unselectedIcon = Icons.Outlined.AccountCircle
//        )
    )

    val localNavController = rememberNavController()
    val currentRoute = localNavController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in topLevelDestinations.map { it.route }) {
                AppNavBar(
                    navController = localNavController,
                    destinations = topLevelDestinations
                )
            }
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AppNavHost(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                navController = localNavController
            )
        }
    }
}