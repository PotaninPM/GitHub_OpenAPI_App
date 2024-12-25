package com.example.hselyceumapp.domain.usecases

import com.example.hselyceumapp.data.local.dao.FavoriteUsersDao
import com.example.hselyceumapp.data.mappers.toDomain
import com.example.hselyceumapp.domain.model.User

class GetFavoritesUseCase(
    private val favoriteUserDao: FavoriteUsersDao
) {
    suspend operator fun invoke(): List<User> {
        return favoriteUserDao.getAllFavorites().map { it.toDomain() }
    }
}