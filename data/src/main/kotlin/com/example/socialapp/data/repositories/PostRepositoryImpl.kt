package com.example.socialapp.data.repositories

import com.example.socialapp.data.clode.models.posts.toDomain
import com.example.socialapp.data.clode.source.PostCloudDataSource
import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.PostDomain
import com.example.socialapp.domain.repositories.PostRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val cloudDataSource: PostCloudDataSource
) : PostRepository {
    override suspend fun fetchAllPost(): Result<List<PostDomain>> {
        return try {
            val users = cloudDataSource.fetchAllPost().map { it.toDomain() }
            Result.Success(data = users)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.Error(message = DEFAULT_ERROR_MESSAGE)
        }
    }
}