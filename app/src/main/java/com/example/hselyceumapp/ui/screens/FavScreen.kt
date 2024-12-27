package com.example.hselyceumapp.ui.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hselyceumapp.data.mappers.toUser
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.ui.components.shimmerLoading
import com.example.hselyceumapp.ui.navigation.Screen
import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavScreen(
    navController: NavController,
    viewModelUser: UsersViewModel = koinViewModel(),
    viewModel: FavoriteUsersViewModel = koinViewModel()
) {
    val favoriteUsers by viewModel.favoriteUsers.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchFavoriteUsers()
    }

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Top))
    ) {
        items(favoriteUsers) { user ->
            UserCard(
                user = User(
                    id = user.id,
                    login = user.login,
                    avatarUrl = user.avatarUrl,
                    htmlUrl = user.htmlUrl
                ),
                isFavorite = true,
                onFavoriteToggle = { viewModel.toggleFavorite(user.toUser()) },
                onClick = {
                    viewModelUser.selectUser(user.toUser())
                    navController.navigate(Screen.UserScreen.route)
                },
                isLoading = false
            )
        }
    }
}