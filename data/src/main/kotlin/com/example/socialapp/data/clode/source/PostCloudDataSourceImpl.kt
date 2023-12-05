package com.example.socialapp.data.clode.source

import android.util.Log
import com.example.socialapp.data.clode.models.posts.PostCloud
import com.example.socialapp.data.clode.service.PostService
import java.util.concurrent.CancellationException
import javax.inject.Inject

class PostCloudDataSourceImpl @Inject constructor(
    private val postService: PostService
) : PostCloudDataSource {
    override suspend fun fetchAllPost(): List<PostCloud> {
        return try {
            postService.fetchAllPost().results
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("SocialApp", e.stackTraceToString())
            emptyList()
        }
    }
}