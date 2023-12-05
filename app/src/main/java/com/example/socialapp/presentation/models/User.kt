package com.example.socialapp.presentation.models

import com.example.socialapp.domain.models.UserDomain

data class User(
    val avatar: String?,
    val bio: String?,
    val createdAt: String,
    val email: String,
    val lastName: String,
    val location: Location?,
    val name: String,
    val objectId: String,
    val password: String,
    val profileBackgroundImage: String?,
    val updatedAt: String
) {
    fun isUnknown() = this == unknown

    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = User(
            avatar = "",
            bio = "",
            createdAt = "",
            email = "",
            lastName = "UnKnown",
            location = null,
            name = "UnKnown",
            objectId = String(),
            password = String(),
            profileBackgroundImage = null,
            updatedAt = String()
        )
    }
}

fun UserDomain.toUser() = this.run {
    if (this == UserDomain.unknown) return@run User.unknown
    User(
        avatar = avatar,
        bio = bio,
        createdAt = createdAt,
        email = email,
        lastName = lastName,
        location = if (location != null) Location(
            longitude = location!!.longitude,
            latitude = location!!.latitude,
            type = location!!.type
        ) else null,
        name = name,
        objectId = objectId,
        password = password,
        profileBackgroundImage = profileBackgroundImage,
        updatedAt = updatedAt
    )
}