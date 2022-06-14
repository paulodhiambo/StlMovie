package com.stlhorizon.stlmovie.data.remote

import com.stlhorizon.stlmovie.data.remote.response.ApiResponse
import retrofit2.http.GET

interface StlAPI {
    @GET("3/movie/top_rated")
    suspend fun getTopRatedMovies(): ApiResponse

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(): ApiResponse
    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies():ApiResponse
}