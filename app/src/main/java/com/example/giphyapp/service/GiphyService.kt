package com.example.giphyapp.service

import GiphyApiClient
import com.example.giphyapp.BuildConfig
import com.example.giphyapp.data.Data


class GiphyService constructor(private val client: GiphyApiClient) {
    suspend fun getGifs(): List<Data> {
        val gifs =
            client.randomGifs(apiKey = BuildConfig.API_KEY).body()?.data.orEmpty()
        return gifs
    }
}