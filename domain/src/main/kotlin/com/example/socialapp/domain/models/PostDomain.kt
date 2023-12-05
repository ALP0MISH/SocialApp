package com.example.socialapp.domain.models


data class PostDomain(
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
)