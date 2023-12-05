package com.example.socialapp.data.clode.models

import com.google.gson.annotations.SerializedName

data class CreateResponse(
    @SerializedName("objectId")
    val id: String,
)