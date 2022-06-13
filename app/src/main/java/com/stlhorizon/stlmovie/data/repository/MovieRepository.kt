package com.stlhorizon.stlmovie.data.repository

import com.stlhorizon.stlmovie.data.local.AppDatabase
import com.stlhorizon.stlmovie.data.remote.StlAPI
import com.stlhorizon.stlmovie.data.remote.response.Movie
import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: StlAPI,
    private val database: AppDatabase
) {
    suspend fun getTopRatedMoviesResponse(): topRatedMoviesResponse= api.getTopRatedMovies()

    suspend fun saveMovie(movie: Movie) = database.movieDao().save(movie)

    suspend fun getMovie(): List<Movie> = database.movieDao().getMovies()

}