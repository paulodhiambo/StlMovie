package com.stlhorizon.stlmovie.data.repository

import com.stlhorizon.stlmovie.data.local.AppDatabase
import com.stlhorizon.stlmovie.data.remote.StlAPI
import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: StlAPI,
    private val database: AppDatabase
) {
    suspend fun getTopRatedMoviesResponse(): topRatedMoviesResponse= api.getTopRatedMovies()
}