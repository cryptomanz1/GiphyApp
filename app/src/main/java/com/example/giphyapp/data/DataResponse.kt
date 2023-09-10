package com.example.giphyapp.data

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("data")
    val data: List<Data>
)