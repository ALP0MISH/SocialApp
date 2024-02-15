package com.example.socialapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.example.socialapp.domain.usecases.current_user.SetOnboardingShowedUseCase
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.socialapp.presentation.navigation.GlobalNavigatorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setOnboardingShowedUseCase: SetOnboardingShowedUseCase,
    private val navigatorManager: GlobalNavigatorManager
) : ViewModel() {

    private val _navControllerFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navControllerFlow: SharedFlow<String> = _navControllerFlow.asSharedFlow()

    fun onBoardingFinished() {
        setOnboardingShowedUseCase()
        _navControllerFlow.tryEmit(LoginDestination.route())
    }
}