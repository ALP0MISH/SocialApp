package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.repositories.CurrentUserRepository

interface IsOnboardingPassedUseCase {
    operator fun invoke(): Boolean
}

class IsOnboardingPassedUseCaseImpl(
    private val currentUserRepository: CurrentUserRepository

) : IsOnboardingPassedUseCase {
    override fun invoke(): Boolean {
        return currentUserRepository.isOnboardingPassed()
    }

}