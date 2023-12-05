package com.example.socialapp.data.cloude.models.comments


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommemetsCloud(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("likes_count")
    val likesCount: Int,
    @SerializedName("message")
    val message: String,
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