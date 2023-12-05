package com.example.socialapp.data.clode.models.posts


import android.os.Parcelable
import com.example.socialapp.data.clode.models.Avatar
import com.example.socialapp.domain.models.PostDomain
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostCloud(
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: ImageCloud?,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("message")
    val message: String?,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("user_avatar")
    val userAvatar: String?,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_last_name")
    val userLastName: String,
    @SerializedName("user_name")
    val userName: String
) : Parcelable

fun PostCloud.toDomain() = this.run {
    PostDomain(
        commentsCount = commentsCount,
        createdAt = createdAt,
        likeCount = likeCount,
        image = image?.url,
        message = message,
        objectId = objectId,
        userId = userId,
        userAvatar = userAvatar,
        userName = userName,
        updatedAt = updatedAt,
        userLastName = userLastName
    )
}