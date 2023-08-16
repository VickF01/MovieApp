package com.example.movieapp.core.domain.repository

import com.example.movieapp.core.data.source.Resource
import com.example.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getNowPlayingMovie(): Flow<Resource<List<Movie>>>
    fun getFavMovie(): Flow<List<Movie>>
    fun setFavMovie(movie: Movie, state: Boolean)
}