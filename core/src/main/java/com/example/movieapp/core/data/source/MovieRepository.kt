package com.example.movieapp.core.data.source

import com.example.movieapp.core.data.source.local.LocalDataSource
import com.example.movieapp.core.data.source.remote.RemoteDataSource
import com.example.movieapp.core.data.source.remote.network.ApiResponse
import com.example.movieapp.core.data.source.remote.response.MovieResponse
import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.core.domain.repository.IMovieRepository
import com.example.movieapp.core.utils.AppExecutors
import com.example.movieapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {
    override fun getNowPlayingMovie(): Flow<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getNowPlayingMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getNowPlayingMovie()
            }

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                localDataSource.insertMovie(DataMapper.mapResponseToEntities(data))
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

        }.asFlow()

    }

    override fun getFavMovie(): Flow<List<Movie>> {
        return localDataSource.getFavMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavMovie(movie: Movie, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavMovie(DataMapper.mapDomainToEntity(movie), state)
        }
    }

}