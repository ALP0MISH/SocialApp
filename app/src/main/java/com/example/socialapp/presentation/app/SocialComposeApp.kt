package com.example.socialapp.presentation.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.socialapp.presentation.navigation.AppNavGraph
import kotlinx.coroutines.flow.Flow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SocialComposeApp(
    destinationsFlow: Flow<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    val (destination, isClearBackStack) = destinationsFlow.collectAsState(initial = "" to false).value

    if (destination.isNotEmpty()) {
        navHostController.navigate(destination) {
            if (isClearBackStack) popUpTo(0)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        AppNavGraph(navHostController = navHostController)
    }
}