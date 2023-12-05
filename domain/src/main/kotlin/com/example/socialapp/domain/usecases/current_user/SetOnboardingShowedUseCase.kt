package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.repositories.CurrentUserRepository

interface SetOnboardingShowedUseCase {
    operator fun invoke()
}

class SetOnboardingShowedUseCaseImpl(
    private val currentUserRepository: CurrentUserRepository

) : SetOnboardingShowedUseCase {
    override fun invoke() {
        currentUserRepository.setOnboardingShowed()
    }

}