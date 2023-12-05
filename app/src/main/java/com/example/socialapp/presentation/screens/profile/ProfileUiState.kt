package com.example.socialapp.presentation.screens.profile

import com.example.socialapp.presentation.models.User

sealed class ProfileUiState {

    data object Initial : ProfileUiState()

    data object Loading : ProfileUiState()

    data class Error(val message: String) : ProfileUiState()

    data class Content(
        val user: User
    ) : ProfileUiState()
}