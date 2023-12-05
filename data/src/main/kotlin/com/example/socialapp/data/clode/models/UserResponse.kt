package com.example.socialapp.data.clode.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    @SerializedName("results")
    val results: List<UserCloud>
): Parcelable