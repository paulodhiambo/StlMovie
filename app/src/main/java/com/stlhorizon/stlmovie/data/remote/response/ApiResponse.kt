package com.stlhorizon.stlmovie.data.remote.response

data class ApiResponse(
    val page: Int,
    val results: List<MovieResponse>,
    val total_pages: Int,
    val total_results: Int
)