package com.example.socialapp.data.cloude.models.user


import android.os.Parcelable
import com.example.socialapp.data.cloude.models.common.ImageModule
import com.example.socialapp.data.cloude.models.common.LocationCloude
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCloude(
    @SerializedName("avatar")
    val avatar: ImageModule?,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("location")
    val location: LocationCloude?,
    @SerializedName("file_baground_image")
    val fileBagroundImage: ImageModule,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("updatedAt")
    val updatedAt: String
): Parcelable