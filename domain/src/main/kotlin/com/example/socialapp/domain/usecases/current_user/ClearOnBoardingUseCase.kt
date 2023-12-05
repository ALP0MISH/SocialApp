package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.repositories.CurrentUserRepository

interface ClearOnBoardingUseCase {
    operator fun invoke()
}

class ClearOnBoardingUseCaseImpl(
    private val currentUserRepository: CurrentUserRepository

) : ClearOnBoardingUseCase {
    override fun invoke() {
        return currentUserRepository.clearOnBoarding()
    }
}