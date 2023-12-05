package com.example.socialapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.socialapp.presentation.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        val state = ProfileUiState.Content(
            user = User.unknown.copy(
                avatar = "https://wallup.net/wp-content/uploads/2017/11/17/272966-Avatar.jpg",
                profileBackgroundImage = "https://wallup.net/wp-content/uploads/2017/11/17/272966-Avatar.jpg"
            )
        )
        _uiState.tryEmit(state)
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditProfile -> {}
            is ProfileEvent.OnFollowClick -> {}
            is ProfileEvent.OnEditBackground -> {}
        }
    }
}