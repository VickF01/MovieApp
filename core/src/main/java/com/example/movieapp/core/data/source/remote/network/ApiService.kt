package com.example.movieapp.core.data.source.remote.network

import com.example.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNjBjODA4MjIzN2RkZmVkZWZiMWUyZjIxNDI5M2M5MiIsInN1YiI6IjY0ZGIxYWNlMDAxYmJkMDExZDkyNDJmYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7wYxkz-L-Jy_mcaGCnrHPZBXGReXMcChCcWAxssUxg0")
    @GET("now_playing")
    suspend fun getNowPlaying(): ListMovieResponse
}