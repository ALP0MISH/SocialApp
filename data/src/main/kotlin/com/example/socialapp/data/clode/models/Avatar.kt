package com.example.socialapp.data.clode.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Avatar(
    @SerializedName("name")
    val name: String,
    @SerializedName("__type")
    val type: String,
    @SerializedName("url")
    val url: String
): Parcelable