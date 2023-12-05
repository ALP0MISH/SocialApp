package com.example.socialapp.domain.usecases.current_user

import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.CurrentUserRepository

interface FetchCurrentUserUseCase {
    operator fun invoke(): UserDomain
}

class FetchCurrentUserImpl(
    private val repository: CurrentUserRepository
) : FetchCurrentUserUseCase {

    override fun invoke(): UserDomain {
        return repository.fetchCurrentUser()
    }
}