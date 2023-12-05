package com.example.socialapp.presentation.screens.home

import com.example.socialapp.presentation.navigation.Destination

object HomeDestination: Destination {
    override fun route(): String = "home_destination"

    override fun routeWithArgs(): String  = route()
}