package com.example.socialapp.data.cloude.models.posts


import android.os.Parcelable
import com.example.socialapp.data.clode.models.posts.PostCloud
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostResponse(
    @SerializedName("results")
    val results: List<PostCloud>
): Parcelable