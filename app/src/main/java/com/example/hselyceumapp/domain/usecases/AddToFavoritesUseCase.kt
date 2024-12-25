package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.data.local.dao.FavoriteUsersDao
import com.example.hselyceumapp.data.mappers.toFavoriteEntity
import com.example.hselyceumapp.domain.model.User

class AddToFavoritesUseCase(
    private val favoriteUserDao: FavoriteUsersDao
) {
    suspend operator fun invoke(user: User) {
        favoriteUserDao.addFavoriteUser(user.toFavoriteEntity())
    }
}