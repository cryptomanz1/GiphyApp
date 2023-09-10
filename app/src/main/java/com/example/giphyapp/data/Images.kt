package com.example.giphyapp.data

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original")
    val original: ImageDetails
)