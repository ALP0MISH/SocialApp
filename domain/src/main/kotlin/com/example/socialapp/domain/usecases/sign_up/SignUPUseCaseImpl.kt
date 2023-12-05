package com.example.socialapp.domain.usecases.sign_up

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.LoginRepository
import com.example.socialapp.domain.repositories.UserRepository

class SignUPUseCaseImpl constructor(
    private val repository: LoginRepository,
    private val userRepository: UserRepository,
) : SignUPUseCase {

    override suspend fun invoke(
        email: String,
        lastName: String,
        name: String,
        password: String
    ): Result<UserDomain> {
        if (email.isEmpty()) {
            return Result.Error(message = "First fill in email")
        }
        if (name.isEmpty()) {
            return Result.Error(message = "First fill in name")
        }
        if (lastName.isEmpty()) {
            return Result.Error(message = "First fill in lastName")
        }
        if (password.length < 0) {
            return Result.Error(message = "Incorrect fill password")
        }
        val response = repository.signUp(
            email = email,
            password = password,
            name = name,
            lastName = lastName
        )
        return userRepository.fetchUserById(response.data?.id ?: String())
    }
}