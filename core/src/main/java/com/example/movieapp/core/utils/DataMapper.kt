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
                it.original_title,
                it.overview,
                it.poster,
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
                it.original_title,
                it.overview,
                it.poster,
                it.vote_average,
                false
            )
        }
    }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        input.id,
        input.original_title,
        input.overview,
        input.poster,
        input.vote_average,
        input.isFavorite
    )
}