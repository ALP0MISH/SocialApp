package com.example.socialapp.presentation.auth.login

import com.example.socialapp.presentation.navigation.Destination

object LoginDestination: Destination {
    override fun route(): String = "login_destination"
    override fun routeWithArgs(): String  = route()
}