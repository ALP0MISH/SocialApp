package com.example.socialapp.domain.repositories

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.PostDomain

interface PostRepository {
    suspend fun fetchAllPost(): Result<List<PostDomain>>
}