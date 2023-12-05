package com.example.socialapp.presentation.screens.onboarding

import com.example.socialapp.presentation.navigation.Destination

object OnBoardingDestination: Destination {
    override fun route(): String = "onboarding_destination"
    override fun routeWithArgs(): String  = route()
}