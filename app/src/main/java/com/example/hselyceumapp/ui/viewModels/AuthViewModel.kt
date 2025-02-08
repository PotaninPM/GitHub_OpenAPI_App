package com.example.hselyceumapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hselyceumapp.domain.repository.AuthRepository
import com.example.hselyceumapp.domain.state.AuthState
import com.example.hselyceumapp.domain.usecases.auth.LoginUseCase
import com.example.hselyceumapp.domain.usecases.auth.LogoutUseCase
import com.example.hselyceumapp.domain.usecases.auth.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    private val logoutUseCase: LogoutUseCase
): ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthorized)
    val authState: StateFlow<AuthState> = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                val success = loginUseCase(email, password)
                _authState.value = if (success) AuthState.Authorized else AuthState.Error("Error")
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Error")
            }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            try {
                val success = registerUseCase(email, password)
                _authState.value = if (success) AuthState.Authorized else AuthState.Error("Error")
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Error")
            }
        }
    }



    fun logout() {
        logoutUseCase()
        _authState.value = AuthState.Unauthorized
    }
}