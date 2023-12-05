package com.example.socialapp.data.cloude.models.subscriptions


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubscribtionsResponse(
    @SerializedName("results")
    val results: List<SubscribtionsCloude>
): Parcelable