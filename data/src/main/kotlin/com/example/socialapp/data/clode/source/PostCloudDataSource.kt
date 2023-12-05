package com.example.socialapp.data.clode.source

import com.example.socialapp.data.clode.models.posts.PostCloud

interface PostCloudDataSource {
    suspend fun fetchAllPost(): List<PostCloud>
}