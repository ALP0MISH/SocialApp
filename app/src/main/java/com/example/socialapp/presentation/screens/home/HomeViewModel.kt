package com.example.socialapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialapp.domain.usecases.post.FetchAllPostUseCase
import com.example.socialapp.domain.usecases.users.FetchAllUsersUseCase
import com.example.socialapp.presentation.models.Post
import com.example.socialapp.presentation.models.User
import com.example.socialapp.presentation.models.toPost
import com.example.socialapp.presentation.models.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllUsersUseCase: FetchAllUsersUseCase,
    private val fetchAllPostUseCase: FetchAllPostUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Initial)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.tryEmit(HomeUiState.Loading)
            val contentState = HomeUiState.Content(
                users = fetchAllUsers(),
                posts = fetchAllPost()
            )
            _uiState.tryEmit(contentState)
        }
    }

    private suspend fun fetchAllUsers(): List<User> {
        val users = fetchAllUsersUseCase().map { it.toUser() }
        delay(2_000)
        return users

    }

    private suspend fun fetchAllPost(): List<Post> {
        val posts = fetchAllPostUseCase().data ?: emptyList()
        delay(2_000)
        return posts.map { it.toPost() }
    }
}