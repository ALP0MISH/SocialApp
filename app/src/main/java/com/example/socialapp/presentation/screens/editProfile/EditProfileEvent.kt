package com.example.socialapp.presentation.screens.editProfile

import android.graphics.Bitmap

sealed class EditProfileEvent {
    data object OnSaveButtonClick : EditProfileEvent()
    data class OnEmailChange(val value: String) : EditProfileEvent()
    data class OnPasswordChange(val value: String) : EditProfileEvent()
    data class OnEducationChange(val value: String) : EditProfileEvent()
    data class OnAboutChange(val value: String) : EditProfileEvent()
    data class OnLastNameChange(val value: String) : EditProfileEvent()
    data class OnNameChange(val value: String) : EditProfileEvent()
    data class OnAvatarChanged(val bitmap: Bitmap) : EditProfileEvent()
}