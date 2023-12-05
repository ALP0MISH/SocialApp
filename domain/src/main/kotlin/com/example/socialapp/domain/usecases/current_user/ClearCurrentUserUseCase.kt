package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.repositories.CurrentUserRepository

interface ClearCurrentUserUseCase {
    operator fun invoke()
}

class ClearCurrentUserUseCaseImpl(
    private val currentUserRepository: CurrentUserRepository

): ClearCurrentUserUseCase{
    override fun invoke() {
        return currentUserRepository.clearCurrentUser()
    }

}