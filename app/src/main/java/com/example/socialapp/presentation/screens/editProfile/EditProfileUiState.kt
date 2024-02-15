package com.example.socialapp.presentation.screens.editProfile

import android.net.Uri
import com.example.socialapp.presentation.models.User

sealed class EditProfileUiState {
    data object Initial : EditProfileUiState()
    data object Loading : EditProfileUiState()
    data class Error(
        val message: String
    ) : EditProfileUiState()

    data class Content(
        val user: User,
        val email: String,
        val lastName: String,
        val name: String,
        val aboutMe: String,
    ) : EditProfileUiState()
}