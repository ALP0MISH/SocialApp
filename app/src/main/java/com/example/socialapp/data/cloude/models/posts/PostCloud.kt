package com.example.socialapp.data.cloude.models.posts


import android.os.Parcelable
import com.example.socialapp.data.cloude.models.common.ImageModule
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostCloud(
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: ImageModule?,
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
): Parcelable