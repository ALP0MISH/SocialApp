package com.example.socialapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.socialapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.example.socialapp.presentation.models.User
import com.example.socialapp.presentation.models.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        try {
            val user = fetchCurrentUserUseCase().toUser()
            _uiState.tryEmit(ProfileUiState.Content(user))
        } catch (e: Exception) {
            val errorState = ProfileUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditProfile -> {}
            is ProfileEvent.OnFollowClick -> {}
            is ProfileEvent.OnEditBackground -> {}
        }
    }
}