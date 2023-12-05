package com.example.socialapp.data.clode.service

import com.example.socialapp.data.clode.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("Users")
    suspend fun fetchUserById(
        @Query("where") params: String,
    ): UserResponse

    @GET("Users")
    suspend fun fetchAllUsers(): UserResponse
}