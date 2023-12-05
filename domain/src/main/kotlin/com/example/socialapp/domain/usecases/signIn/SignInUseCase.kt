package com.example.socialapp.domain.usecases.signIn

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.CreateResponseDomain
import com.example.socialapp.domain.models.UserDomain

interface SignInUseCase {
    suspend operator fun invoke(email: String,password: String): Result<UserDomain>
}