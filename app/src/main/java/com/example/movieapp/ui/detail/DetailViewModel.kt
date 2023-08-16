package com.example.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavMovie(movie: Movie, status: Boolean) = movieUseCase.setFavMovie(movie, status)
}