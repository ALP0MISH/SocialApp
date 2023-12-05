package com.example.socialapp.presentation.navigation

interface Destination {
    fun route(): String
    fun routeWithArgs(): String
}