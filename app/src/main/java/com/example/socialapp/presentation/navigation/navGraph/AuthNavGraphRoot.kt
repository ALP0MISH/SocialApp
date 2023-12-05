package com.example.socialapp.presentation.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.auth.login.LoginScreen
import com.example.socialapp.presentation.auth.login.LoginViewModel
import com.example.socialapp.presentation.auth.signup.SignUpDestination
import com.example.socialapp.presentation.auth.signup.SignUpScreen
import com.example.socialapp.presentation.auth.signup.SignUpViewModel
import com.example.socialapp.presentation.screens.onboarding.OnBoardingDestination
import com.example.socialapp.presentation.screens.onboarding.OnBoardingScreen
import com.example.socialapp.presentation.screens.onboarding.OnBoardingViewModel

const val AUTH_NAV_GRAPH_ROUTE = "auth_nav_graph_route"

@Composable
fun AuthNavGraphRoot(

) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginDestination.route()
    ) {
        composable(OnBoardingDestination.route()) {
            val viewModel: OnBoardingViewModel = hiltViewModel()
            OnBoardingScreen(
                navigateToLoginScreen = { viewModel.onBoardingFinished() }
            )
        }
        composable(LoginDestination.route()) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(
                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
                onEvent = viewModel::onEvent
            )
        }
        composable(SignUpDestination.route()) {
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(
                uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
                onEvent = viewModel::onEvent
            )
        }
    }
}