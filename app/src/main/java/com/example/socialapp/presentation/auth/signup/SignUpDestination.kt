package com.example.socialapp.presentation.auth.signup

import com.example.socialapp.presentation.navigation.Destination

object SignUpDestination: Destination {
    override fun route(): String = "signup_screen"

    override fun routeWithArgs(): String = route()
}