package com.stlhorizon.stlmovie.data.repository

import com.stlhorizon.stlmovie.data.local.AppDatabase
import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.TopRatedMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie
import com.stlhorizon.stlmovie.data.remote.StlAPI
import com.stlhorizon.stlmovie.data.remote.response.ApiResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: StlAPI,
    private val database: AppDatabase
) {
    suspend fun getTopRatedMoviesResponse(): ApiResponse= api.getTopRatedMovies()

    suspend fun saveMovie(movie: PopularMovie) = database.movieDao().save(movie)
    suspend fun saveMovie(movie: UpcomingMovie) = database.movieDao().save(movie)
    suspend fun saveMovie(movie: TopRatedMovie) = database.movieDao().save(movie)

    suspend fun getPopularMovie(): List<PopularMovie> = database.movieDao().getPopularMovies()
    suspend fun getTopMovie(): List<TopRatedMovie> = database.movieDao().getTopRatedMovies()
    suspend fun getUpcomingMovie(): List<UpcomingMovie> = database.movieDao().getMovies()

    suspend fun getPopularMovies(): ApiResponse = api.getPopularMovies()

    suspend fun getUpcomingMovies(): ApiResponse = api.getUpcomingMovies()



}