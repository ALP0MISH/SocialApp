package com.example.socialapp.presentation.screens.profile

sealed class ProfileEvent {

    data object OnEditBackground : ProfileEvent()

    data object OnEditProfile : ProfileEvent()

    data object OnFollowClick : ProfileEvent()
}