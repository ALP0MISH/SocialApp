package com.example.socialapp.presentation.models

import com.example.socialapp.data.clode.models.posts.PostCloud
import com.example.socialapp.domain.models.PostDomain

data class Post(
    val commentsCount: Int,
    val createdAt: String,
    val image: String?,
    val likeCount: Int,
    val message: String?,
    val objectId: String,
    val updatedAt: String,
    val userAvatar: String?,
    val userId: String,
    val userLastName: String,
    val userName: String,
    val isOwnPost: Boolean = false
) {
    companion object {
        val unkniwn = Post(
            commentsCount = 0,
            createdAt = "",
            image = "",
            likeCount = 0,
            message = "",
            objectId = "",
            updatedAt = "",
            userLastName = "",
            userName = "",
            isOwnPost = false,
            userAvatar = "",
            userId = ""
        )
    }
}

fun PostDomain.toPost() = this.run {
    Post(
        commentsCount = commentsCount,
        createdAt = createdAt,
        likeCount = likeCount,
        image = image,
        message = message,
        objectId = objectId,
        userId = userId,
        userAvatar = userAvatar,
        userName = userName,
        updatedAt = updatedAt,
        userLastName = userLastName,
        isOwnPost = isOwnPost
    )
}