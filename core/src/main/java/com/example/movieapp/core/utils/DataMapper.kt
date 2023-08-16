package com.example.movieapp.core.utils

import com.example.movieapp.core.data.source.local.entity.MovieEntity
import com.example.movieapp.core.data.source.remote.response.MovieResponse
import com.example.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponseToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val newsList = ArrayList<MovieEntity>()
        input.map {
            val news = MovieEntity(
                it.id,
                it.title,
                it.overview,
                "https://image.tmdb.org/t/p/w500" + it.poster_path,
                it.vote_average,
                false
            )
            newsList.add(news)
        }
        return newsList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> {
        return input.map {
            Movie(
                it.id,
                it.title,
                it.overview,
                it.poster_path,
                it.vote_average,
                false
            )
        }
    }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        input.id,
        input.title,
        input.overview,
        input.poster_path,
        input.vote_average,
        input.isFavorite
    )
}