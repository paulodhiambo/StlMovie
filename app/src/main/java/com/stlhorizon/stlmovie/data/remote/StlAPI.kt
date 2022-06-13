package com.stlhorizon.stlmovie.data.remote

import com.stlhorizon.stlmovie.data.remote.response.topRatedMoviesResponse
import retrofit2.http.GET

interface StlAPI {
    @GET("3/movie/top_rated")
    suspend fun getTopRatedMovies(): topRatedMoviesResponse
}