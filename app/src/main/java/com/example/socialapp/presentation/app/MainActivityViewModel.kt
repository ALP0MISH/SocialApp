package com.example.socialapp.presentation.app

import androidx.lifecycle.ViewModel
import com.example.socialapp.presentation.navigation.NavigatorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager
) : ViewModel() {
    val destinationsFlow = navigatorManager.destinationsFlow()
}