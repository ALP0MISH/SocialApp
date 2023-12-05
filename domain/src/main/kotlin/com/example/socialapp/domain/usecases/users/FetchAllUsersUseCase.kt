package com.example.socialapp.domain.usecases.users

import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.CurrentUserRepository
import com.example.socialapp.domain.repositories.UserRepository

interface FetchAllUsersUseCase {
    suspend operator fun invoke(): List<UserDomain>
}

class FetchAllUsersUseCaseImpl(
    private val userRepository: UserRepository,
    private val currentUserRepository: CurrentUserRepository
) : FetchAllUsersUseCase {
    override suspend fun invoke(): List<UserDomain> {
        val allUsers = userRepository.fetchAllUsers().data
        val currentUser = currentUserRepository.fetchCurrentUser()
        return allUsers?.filter { it.objectId != currentUser.objectId } ?: listOf()
    }
}