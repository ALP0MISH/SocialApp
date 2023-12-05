package com.example.socialapp.presentation.screens.splash

import com.example.socialapp.presentation.navigation.Destination

object SplashDestination : Destination {
    override fun route(): String  = "splash_screen_route"
    override fun routeWithArgs(): String  = route()
}