package com.example.movieapp.core.data.source.remote.response

data class MovieResponse(
    val id: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val vote_average: String
)