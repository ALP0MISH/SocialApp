package com.example.socialapp.domain.models

data class UserDomain(
    val avatar: String?,
    val bio: String?,
    val createdAt: String,
    val email: String,
    val lastName: String,
    val location: LocationDomain?,
    val name: String,
    val objectId: String,
    val password: String,
    val profileBackgroundImage: String?,
    val updatedAt: String
) {
    companion object {
        val unknown = UserDomain(
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