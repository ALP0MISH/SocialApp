package com.example.socialapp.data.cloude.models.user


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    @SerializedName("results")
    val results: List<UserCloude>
): Parcelable