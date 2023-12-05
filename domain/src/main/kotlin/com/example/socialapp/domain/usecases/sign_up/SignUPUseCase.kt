package com.example.socialapp.domain.usecases.sign_up

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.CreateResponseDomain
import com.example.socialapp.domain.models.UserDomain

interface SignUPUseCase {
    suspend operator fun invoke(
        email: String,
        lastName: String,
        name: String,
        password: String
    ): Result<UserDomain>
}