package com.example.socialapp.domain.repositories

import com.example.socialapp.domain.models.UserDomain

interface CurrentUserRepository {
    fun saveCurrentUser(user: UserDomain)
    fun fetchCurrentUser(): UserDomain
    fun clearCurrentUser()
    fun isOnboardingPassed(): Boolean
    fun setOnboardingShowed()
    fun clearOnBoarding()
}