package com.example.hselyceumapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.domain.usecases.AddUserUseCase
import com.example.hselyceumapp.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> get() = _selectedUser

    fun fetchUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            try {
                _users.value = getUsersUseCase()
            } catch(e: Exception) {
                Log.i("INFOG", "$e")
            }
            _isLoading.value = false
        }
    }

    fun selectUser(user: User) {
        _selectedUser.value = user
    }

    fun addUsers(user: User) {
        viewModelScope.launch {
            addUserUseCase(user)
            fetchUsers()
        }
    }
}