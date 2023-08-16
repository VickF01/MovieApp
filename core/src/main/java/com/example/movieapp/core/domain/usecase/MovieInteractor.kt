package com.example.movieapp.core.domain.usecase

import com.example.movieapp.core.data.source.Resource
import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getNowPlayingMovie(): Flow<Resource<List<Movie>>> {
        return movieRepository.getNowPlayingMovie()
    }

    override fun getFavMovie(): Flow<List<Movie>> {
        return movieRepository.getFavMovie()
    }

    override fun setFavMovie(movie: Movie, state: Boolean) {
        return movieRepository.setFavMovie(movie, state)
    }

}