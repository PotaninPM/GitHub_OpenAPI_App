package com.example.hselyceumapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppNavBar(
    navController: NavHostController,
    destinations: List<BottomNavItem>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        destinations.forEach { destination ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == destination.route } == true

            NavigationBarItem(
                selected = isSelected, 
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) destination.selectedIcon else destination.unselectedIcon,
                        contentDescription = stringResource(id = destination.labelRes)
                    )
                },
                label = {
                    Text(text = stringResource(id = destination.labelRes))
                }
            )
        }
    }
}