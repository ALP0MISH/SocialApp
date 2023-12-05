package com.example.socialapp.domain.usecases.post

import com.example.socialapp.domain.common.Result
import com.example.socialapp.domain.models.PostDomain
import com.example.socialapp.domain.repositories.CurrentUserRepository
import com.example.socialapp.domain.repositories.PostRepository

interface FetchAllPostUseCase {
    suspend operator fun invoke(): Result<List<PostDomain>>
}
class FetchAllPostUseCaseImpl(
    private val postRepository: PostRepository,
    private val currentUserRepository: CurrentUserRepository,
) : FetchAllPostUseCase {
    override suspend fun invoke(): Result<List<PostDomain>> {
        val postResult = postRepository.fetchAllPost()
        val allPosts = postResult.data ?: emptyList()
        val currentUserId = currentUserRepository.fetchCurrentUser().objectId
        val filteredPosts = allPosts.map { it.copy(isOwnPost = currentUserId == it.userId) }
        return postResult.copy(filteredPosts)
    }
}