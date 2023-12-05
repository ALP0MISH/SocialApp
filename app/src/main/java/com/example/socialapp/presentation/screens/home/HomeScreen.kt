package com.example.socialapp.presentation.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.socialapp.R
import com.example.socialapp.presentation.components.OnBoardingSelection
import com.example.socialapp.presentation.components.PostItem
import com.example.socialapp.presentation.components.TabBar
import com.example.socialapp.presentation.models.Post
import com.example.socialapp.presentation.screens.common.ErrorScreen
import com.example.socialapp.presentation.screens.common.LoadingScreen
import com.example.socialapp.presentation.theme.LargeSpacing

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TabBar(
                title = stringResource(id = R.string.home),
                aligment = Alignment.Center
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is HomeUiState.Initial -> Unit
            is HomeUiState.Loading -> LoadingScreen()
            is HomeUiState.Error -> ErrorScreen(
                message = uiState.message,
                onClick = { }
            )

            is HomeUiState.Content -> LoadedHomeScreen(
                uiState = uiState,
                modifier = modifier.padding(innerPadding),

                )
        }
    }
}

@Composable
fun LoadedHomeScreen(
    uiState: HomeUiState.Content,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = LargeSpacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            OnBoardingSelection(users = uiState.users)
        }
        items(
            items = uiState.posts,
            key = { it.objectId }
        ) { post ->
            PostItem(post = post)
        }
    }
}
