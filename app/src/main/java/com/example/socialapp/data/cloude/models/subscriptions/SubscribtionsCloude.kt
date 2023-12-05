package com.example.socialapp.data.cloude.models.subscriptions


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubscribtionsCloude(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("followed_id")
    val followedId: String,
    @SerializedName("follower_id")
    val followerId: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
): Parcelable