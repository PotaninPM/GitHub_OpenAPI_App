package com.example.hselyceumapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.data.room.dao.FavoriteDao
import com.example.hselyceumapp.data.room.entities.FavoriteUserEntity
import com.example.hselyceumapp.domain.model.GitHubUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteUsersViewModel(
    private val favoriteDao: FavoriteDao
) : ViewModel() {
    private val _favoriteUsers = MutableStateFlow<List<FavoriteUserEntity>>(emptyList())
    val favoriteUsers = _favoriteUsers.asStateFlow()

    fun toggleFavorite(user: GitHubUser) {
        viewModelScope.launch {
            val isFavorite = favoriteDao.isUserFavorite(user.id)
            if (isFavorite) {
                favoriteDao.deleteFavorite(
                    FavoriteUserEntity(
                        id = user.id,
                        login = user.login,
                        avatarUrl = user.avatarUrl,
                        htmlUrl = user.htmlUrl
                    )
                )
            } else {
                favoriteDao.insertFavorite(
                    FavoriteUserEntity(
                        id = user.id,
                        login = user.login,
                        avatarUrl = user.avatarUrl,
                        htmlUrl = user.htmlUrl
                    )
                )
            }
            fetchFavoriteUsers()
        }
    }

    fun fetchFavoriteUsers() {
        viewModelScope.launch {
            _favoriteUsers.value = favoriteDao.getFavoriteUsers()
        }
    }
}