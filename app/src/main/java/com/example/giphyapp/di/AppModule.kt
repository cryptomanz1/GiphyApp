package com.example.giphyapp.di

import GiphyApiClient
import com.example.giphyapp.service.GiphyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideGiphyService(): GiphyService {
        val okhttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val client = retrofit.create(GiphyApiClient::class.java)
        return GiphyService(client)

    }

    private const val BASE_URL = "https://api.giphy.com/v1/"
}