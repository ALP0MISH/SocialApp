package com.example.socialapp.data.mappers

import com.example.socialapp.data.clode.models.UserCloud
import com.example.socialapp.domain.models.LocationDomain
import com.example.socialapp.domain.models.UserDomain

fun UserCloud.toDomain(): UserDomain = this.run {
    UserDomain(
        avatar = avatar?.url,
        bio = bio,
        createdAt = createdAt,
        email = email,
        lastName = lastName,
        location = if (location != null) LocationDomain(
            latitude = location.latitude,
            longitude = location.longitude,
            type = location.type,
        ) else null,
        name = name,
        objectId = objectId,
        password = password,
        updatedAt = updatedAt,
        profileBackgroundImage = profileBackgroundImage?.url
    )
}