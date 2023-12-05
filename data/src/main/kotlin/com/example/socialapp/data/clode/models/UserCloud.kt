package com.example.socialapp.data.clode.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCloud(
    @SerializedName("avatar")
    val avatar: Avatar?,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("profile_background_image")
    val profileBackgroundImage: ProfileBackgroundImage?,
    @SerializedName("updatedAt")
    val updatedAt: String
): Parcelable