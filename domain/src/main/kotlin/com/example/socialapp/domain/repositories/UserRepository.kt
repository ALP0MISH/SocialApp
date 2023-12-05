package com.example.socialapp.domain.repositories

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.UserDomain

interface UserRepository {
    suspend fun fetchUserById(id: String): Result<UserDomain>

    suspend fun fetchAllUsers(): Result<List<UserDomain>>

    suspend fun deleteUserById(id: String)

    suspend fun updateUser(user: UserDomain):  Result<UserDomain>
}