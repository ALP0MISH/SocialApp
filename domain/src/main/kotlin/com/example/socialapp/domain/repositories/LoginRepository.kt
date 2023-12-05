package com.example.socialapp.domain.repositories

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.CreateResponseDomain
import com.example.socialapp.domain.models.UserDomain

interface LoginRepository {
    suspend fun signIn(email: String, password: String): Result<UserDomain>
    suspend fun signUp(
        email: String,
        lastName: String,
        name: String,
        password: String
    ): Result<CreateResponseDomain>
}