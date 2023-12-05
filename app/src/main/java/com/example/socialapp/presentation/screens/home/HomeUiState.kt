package com.example.socialapp.presentation.screens.home

import com.example.socialapp.presentation.models.Post
import com.example.socialapp.presentation.models.User

sealed class HomeUiState {
    data object Loading : HomeUiState()

    data object Initial : HomeUiState()

    data class Error(val message: String) : HomeUiState()

    data class Content(
        val users: List<User> = emptyList(),
        val posts: List<Post> = emptyList()
    ) : HomeUiState()
}