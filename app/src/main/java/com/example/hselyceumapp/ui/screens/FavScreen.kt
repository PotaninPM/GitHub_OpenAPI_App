package com.example.hselyceumapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.hselyceumapp.ui.viewModels.FavoriteUsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavScreen(
    viewModel: FavoriteUsersViewModel = koinViewModel(),
) {
    val favoriteUsers by viewModel.favoriteUsers.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchFavoriteUsers()
    }

    LazyColumn {
        items(favoriteUsers) { user ->
//            UserCard(
//                user = user,
//                isFavorite = user.is_favorite == 1,
//                onFavoriteToggle = { onFavoriteToggle(user) },
//                onClick = {
//                    onClick(user)
//                }
//            )
        }
    }
}