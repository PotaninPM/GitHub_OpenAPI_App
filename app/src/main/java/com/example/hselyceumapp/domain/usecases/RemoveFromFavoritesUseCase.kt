package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.data.local.dao.FavoriteUsersDao

class RemoveFromFavoritesUseCase(
    private val favoriteUserDao: FavoriteUsersDao
) {
    suspend operator fun invoke(userId: Int): Boolean {
        return favoriteUserDao.isFavorite(userId)
    }
}