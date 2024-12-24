package com.example.hselyceumapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.domain.model.User
import com.example.hselyceumapp.domain.usecases.AddUserUseCase
import com.example.hselyceumapp.domain.usecases.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                _users.value = getUsersUseCase()
            } catch(e: Exception) {
                Log.i("INFOG", "$e")
            }
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