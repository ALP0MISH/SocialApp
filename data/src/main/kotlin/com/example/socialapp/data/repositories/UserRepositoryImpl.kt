package com.example.socialapp.data.repositories

import android.util.Log
import com.example.socialapp.data.clode.service.UserService
import com.example.socialapp.data.mappers.toDomain
import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.UserRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService
) : UserRepository {
    override suspend fun fetchUserById(id: String): Result<UserDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchUserById(params)
            val user = response.results.first().toDomain()
            Result.Success(data = user)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("SocialApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllUsers(): Result<List<UserDomain>> {
        return try {
            val userCloud = service.fetchAllUsers().results
            Result.Success(data = userCloud.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("SocialApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteUserById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: UserDomain): Result<UserDomain> {
        TODO("Not yet implemented")
    }
}