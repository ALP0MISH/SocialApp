package com.example.socialapp.presentation.navigation.navGraph

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialapp.presentation.navigation.AppBottomNavigation
import com.example.socialapp.presentation.navigation.BottomTabs
import com.example.socialapp.presentation.screens.editProfile.EDIT_PROFILE_ROUTE
import com.example.socialapp.presentation.screens.editProfile.EditProfileScreen
import com.example.socialapp.presentation.screens.editProfile.EditProfileViewModel
import com.example.socialapp.presentation.screens.home.HomeScreen
import com.example.socialapp.presentation.screens.home.HomeViewModel
import com.example.socialapp.presentation.screens.profile.ProfileScreen
import com.example.socialapp.presentation.screens.profile.ProfileViewModel

const val MAIN_NAV_GRAPH_ROUTE = "main_nav_graph_route"

@Composable
fun MainNavGraphRoot() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController = navHostController)
        }
    ) { innerPaddings ->

        NavHost(
            modifier = Modifier.padding(bottom = innerPaddings.calculateBottomPadding()),
            navController = navHostController,
            startDestination = BottomTabs.Home.route
        ) {
            composable(BottomTabs.Home.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                HomeScreen(uiState = uiState)
            }
            composable(BottomTabs.Search.route) {

            }
            composable(BottomTabs.AddPost.route) {

            }
            composable(BottomTabs.NOTIFICATION.route) {

            }

            composable(BottomTabs.PROFILE.route) {
                val viewModel: ProfileViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val navCommand by viewModel.navControllerFlow.collectAsStateWithLifecycle(
                    initialValue = null,
                )

                LaunchedEffect(key1 = navCommand) {
                    if (navCommand != null) navHostController.navigate(navCommand!!)
                }
                ProfileScreen(
                    uiState = uiState,
                    onEvent = viewModel::onEvent
                )
            }
            composable(EDIT_PROFILE_ROUTE) {
                val viewModel: EditProfileViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val uploadProgress by viewModel.uploadProgress.collectAsStateWithLifecycle(initialValue = null)
                EditProfileScreen(
                    uiState = uiState,
                    onEvent = viewModel::onEvent,
                    navController = navHostController,
                    uploadProgress = uploadProgress
                )
            }
        }
    }
}