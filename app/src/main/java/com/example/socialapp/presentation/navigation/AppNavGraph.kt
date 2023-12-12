package com.example.socialapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.socialapp.presentation.navigation.navGraph.AUTH_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.navigation.navGraph.AuthNavGraphRoot
import com.example.socialapp.presentation.navigation.navGraph.MAIN_NAV_GRAPH_ROUTE
import com.example.socialapp.presentation.navigation.navGraph.MainNavGraphRoot
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