package com.example.hselyceumapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.domain.model.GitHubUser
import com.example.hselyceumapp.domain.usecases.GetGitHubUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetGitHubUsersUseCase
) : ViewModel() {
    private val _users = MutableStateFlow<List<GitHubUser>>(emptyList())
    val users: StateFlow<List<GitHubUser>> = _users

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _selectedUser = MutableStateFlow<GitHubUser?>(null)
    val selectedUser: StateFlow<GitHubUser?> get() = _selectedUser

    private var lastUserId: String? = null
    private var isLastPage = false

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val newUsers = getUsersUseCase(lastUserId)
                if (newUsers.isNotEmpty()) {
                    lastUserId = newUsers.last().id.toString()
                    _users.value += newUsers
                } else {
                    isLastPage = true
                }
            } catch (e: Exception) {
                Log.e("UsersViewModel", "Ошибка $e")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadMoreUsers() {
        if (!isLastPage && !_isLoading.value) {
            fetchUsers()
        }
    }

    fun selectUser(user: GitHubUser) {
        _selectedUser.value = user
    }
}