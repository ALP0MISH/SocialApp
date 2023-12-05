package com.example.socialapp.data.cloude.models.stories


import android.os.Parcelable
import com.example.socialapp.data.cloude.models.common.ImageModule
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoriesCloude(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: ImageModule?,
    @SerializedName("messege")
    val messege: String?,
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