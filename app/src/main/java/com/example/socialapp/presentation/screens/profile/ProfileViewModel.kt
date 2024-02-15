package com.example.socialapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.socialapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.example.socialapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.socialapp.presentation.models.toUser
import com.example.socialapp.presentation.screens.editProfile.EDIT_PROFILE_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _navControllerFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navControllerFlow: SharedFlow<String> = _navControllerFlow.asSharedFlow()


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
            is ProfileEvent.OnEditProfile -> navigateToEditProfileScreen()
            is ProfileEvent.OnFollowClick -> {}
            is ProfileEvent.OnEditBackground -> {}
        }
    }
    private fun navigateToEditProfileScreen() {
        _navControllerFlow.tryEmit(EDIT_PROFILE_ROUTE)
    }
}