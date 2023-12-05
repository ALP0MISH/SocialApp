package com.example.socialapp.data.cloude.models.stories


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoriesResponse(
    @SerializedName("results")
    val results: List<StoriesCloude>
) : Parcelable