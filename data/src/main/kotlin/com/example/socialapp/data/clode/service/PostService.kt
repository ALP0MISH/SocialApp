package com.example.socialapp.data.clode.service

import com.example.socialapp.data.clode.models.posts.PostResponse
import retrofit2.http.GET

interface PostService {
    @GET("Posts")
    suspend fun fetchAllPost(): PostResponse
}