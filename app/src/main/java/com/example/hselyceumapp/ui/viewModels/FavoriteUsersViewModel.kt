package com.example.hselyceumapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.data.local.dao.FavoriteDao
import com.example.hselyceumapp.data.mappers.toUser
import com.example.hselyceumapp.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteUsersViewModel(
    private val favoriteDao: FavoriteDao
) : ViewModel() {
    private val _favoriteUsers = MutableStateFlow<List<User>>(emptyList())
    val favoriteUsers: StateFlow<List<User>> get() = _favoriteUsers

    fun toggleFavorite(user: User) {
        viewModelScope.launch {
            val updatedFavoriteStatus = if (user.is_favorite == 0) 1 else 0
            favoriteDao.updateUserFavoriteStatus(user.id, updatedFavoriteStatus)
            fetchFavoriteUsers()
        }
    }

    fun fetchFavoriteUsers() {
        viewModelScope.launch {
            _favoriteUsers.value = favoriteDao.getFavoriteUsers().map { it.toUser() }
        }
    }
}