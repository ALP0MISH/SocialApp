package com.example.socialapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.socialapp.presentation.auth.login.LoginDestination
import com.example.socialapp.presentation.auth.login.LoginScreen
import com.example.socialapp.presentation.auth.login.LoginViewModel
import com.example.socialapp.presentation.auth.signup.SignUpDestination
import com.example.socialapp.presentation.auth.signup.SignUpScreen
import com.example.socialapp.presentation.auth.signup.SignUpViewModel
import com.example.socialapp.presentation.navigation.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.navigation.navGraph.AuthNavGraphRoot
import com.example.socialapp.presentation.navigation.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.navigation.navGraph.MainNavGraphRoot
import com.example.socialapp.presentation.screens.home.HomeDestination
import com.example.socialapp.presentation.screens.home.HomeScreen
import com.example.socialapp.presentation.screens.home.HomeViewModel
import com.example.socialapp.presentation.screens.onboarding.OnBoardingDestination
import com.example.socialapp.presentation.screens.onboarding.OnBoardingScreen
import com.example.socialapp.presentation.screens.onboarding.OnBoardingViewModel
import com.example.socialapp.presentation.screens.splash.SplashDestination
import com.example.socialapp.presentation.screens.splash.SplashScreen
import com.example.socialapp.presentation.screens.splash.SplashViewModel

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = SplashDestination.route()
    ) {
        composable(SplashDestination.route()) {
            val viewModel: SplashViewModel = hiltViewModel()
            viewModel
            SplashScreen()
        }
        composable(AUTH_NAV_GRAPH_ROUTE) {
            AuthNavGraphRoot()
        }
        composable(MAIN_NAV_GRAPH_ROUTE) {
            MainNavGraphRoot()
        }
    }
}