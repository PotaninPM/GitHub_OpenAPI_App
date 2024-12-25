package com.example.hselyceumapp.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.domain.usecases.AddToFavoritesUseCase
import com.example.hselyceumapp.domain.usecases.GetFavoritesUseCase
import com.example.hselyceumapp.domain.usecases.RemoveFromFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoritesViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
): ViewModel() {
    private val _favoriteUsers = MutableStateFlow<List<User>>(emptyList())
    val favoriteUsers: StateFlow<List<User>> get() = _favoriteUsers


}