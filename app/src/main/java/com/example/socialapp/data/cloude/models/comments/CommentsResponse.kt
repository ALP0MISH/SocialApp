package com.example.socialapp.data.cloude.models.comments


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentsResponse(
    @SerializedName("results")
    val results: List<CommemetsCloud>
): Parcelable