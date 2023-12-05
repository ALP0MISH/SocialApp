package com.example.socialapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.example.socialapp.domain.usecases.current_user.SetOnboardingShowedUseCase
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.navigation.NavigatorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setOnboardingShowedUseCase: SetOnboardingShowedUseCase,
    private val navigatorManager: NavigatorManager
) : ViewModel() {

    fun onBoardingFinished() {
        setOnboardingShowedUseCase()
        navigatorManager.navigateTo(LoginDestination.route(),true)
    }
}