package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.CurrentUserRepository

interface SaveCurrentUserUseCase {
    operator fun invoke(user: UserDomain)
}

class SaveCurrentUserUseCaseImpl (
    private val currentUserRepository: CurrentUserRepository
) : SaveCurrentUserUseCase{
    override fun invoke(user: UserDomain) {
        return currentUserRepository.saveCurrentUser(user = user)
    }
}