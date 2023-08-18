package com.example.movieapp.core.data.source.remote.network

import com.example.movieapp.core.BuildConfig
import com.example.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: ${BuildConfig.TOKEN}")
    @GET("now_playing")
    suspend fun getNowPlaying(): ListMovieResponse
}