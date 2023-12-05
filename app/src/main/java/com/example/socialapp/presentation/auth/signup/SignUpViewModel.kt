package com.example.socialapp.presentation.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialapp.data.repositories.DEFAULT_ERROR_MESSAGE
import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.example.socialapp.domain.usecases.sign_up.SignUPUseCase
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.managers.ShowToastUseCase
import com.example.socialapp.presentation.navigation.NavigatorManager
import com.example.socialapp.presentation.screens.home.HomeDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUPUseCase: SignUPUseCase,
    private val saveCurrentUserUseCase: SaveCurrentUserUseCase,
    private val showToastUseCase: ShowToastUseCase,
    private val navigatorManager: NavigatorManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnEmailChange -> doEmailChange(event)
            is SignUpEvent.OnNameChange -> doNameChange(event)
            is SignUpEvent.OnLastNameChange -> doLastNameChange(event)
            is SignUpEvent.OnPasswordChange -> doPasswordChange(event)
            is SignUpEvent.OnLoginClick -> onLoginClick()
            is SignUpEvent.OnSingUpCLick -> onSingUpCLick()
        }
    }

    private fun onSingUpCLick() {
        viewModelScope.launch {
            val result = signUPUseCase(
                name = uiState.value.name,
                lastName = uiState.value.lastName,
                email = uiState.value.email,
                password = uiState.value.password
            )
            when (result) {
                is Result.Error -> {
                    showToastUseCase.showToast(result.message ?: DEFAULT_ERROR_MESSAGE)
                    Log.e("SocialApp", result.message ?: "")
                }

                is Result.Success -> {
                    val user = result.data ?: return@launch
                    saveCurrentUserUseCase(user)
                    navigatorManager.navigateTo(HomeDestination.route(), true)
                    Log.e("SocialApp", "${result.data}")
                }
            }
        }
    }

    private fun onLoginClick() {
        navigatorManager.navigateTo(LoginDestination.route())
    }

    private fun doPasswordChange(event: SignUpEvent.OnPasswordChange) {
        _uiState.update { currentState ->
            currentState.copy(password = event.value)
        }
    }

    private fun doEmailChange(event: SignUpEvent.OnEmailChange) {
        _uiState.update { currentState ->
            currentState.copy(email = event.value)
        }
    }

    private fun doNameChange(event: SignUpEvent.OnNameChange) {
        _uiState.update { currentState ->
            currentState.copy(name = event.value)
        }
    }

    private fun doLastNameChange(event: SignUpEvent.OnLastNameChange) {
        _uiState.update { currentState ->
            currentState.copy(lastName = event.value)
        }
    }
}