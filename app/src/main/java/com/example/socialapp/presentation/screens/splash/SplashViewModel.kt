package com.example.socialapp.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialapp.domain.usecases.current_user.FetchCurrentUserUseCase
import com.example.socialapp.domain.usecases.current_user.IsOnboardingPassedUseCase
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.models.toUser
import com.example.socialapp.presentation.navigation.NavigatorManager
import com.example.socialapp.presentation.navigation.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.navigation.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.screens.home.HomeDestination
import com.example.socialapp.presentation.screens.onboarding.OnBoardingDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "SocialApp"

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager,
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase,
    private val onboardingPassedUseCase: IsOnboardingPassedUseCase
) : ViewModel() {
    init {
        val currentUser = fetchCurrentUserUseCase().toUser()
        val isOnboardingPassed = onboardingPassedUseCase()
        viewModelScope.launch {
            delay(3000)
            val destination = when {
                currentUser.isNotUnknown() -> MAIN_NAV_GRAPH_ROUTE
                isOnboardingPassed -> AUTH_NAV_GRAPH_ROUTE
                else -> AUTH_NAV_GRAPH_ROUTE
            }
            navigatorManager.navigateTo(destination, true)
        }
    }
}