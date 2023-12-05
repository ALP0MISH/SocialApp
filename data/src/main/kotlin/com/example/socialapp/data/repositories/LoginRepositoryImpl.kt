package com.example.socialapp.data.repositories

import android.util.Log
import com.example.socialapp.data.clode.service.LoginService
import com.example.socialapp.data.clode.models.SignUpParams
import com.example.socialapp.data.mappers.toDomain
import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.CreateResponseDomain
import com.example.socialapp.domain.models.UserDomain
import com.example.socialapp.domain.repositories.LoginRepository
import java.time.LocalDateTime
import java.util.concurrent.CancellationException
import javax.inject.Inject

const val DEFAULT_ERROR_MESSAGE = "Something went Wrong"

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginService
) : LoginRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): Result<UserDomain> {
        return try {
            val response = service.signIn("{\"email\":\"$email\", \"password\":\"$password\"}")
            val result = response.body()?.results!!.first()
            Result.Success(data = result.toDomain())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("abdurahman", e.stackTraceToString())
            Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun signUp(
        email: String,
        lastName: String,
        name: String,
        password: String
    ): Result<CreateResponseDomain> = try {
        val params = SignUpParams(
            email = email,
            lastName = lastName,
            name = name,
            password = password
        )
        val response = service.signUp(params)
        val result = response.body()!!
        Result.Success(
            CreateResponseDomain(
                id = result.id,
            )
        )
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.e("abdurahman", e.stackTraceToString())
        Result.Error(DEFAULT_ERROR_MESSAGE)
    }
}