package com.stlhorizon.stlmovie.data.remote.response

data class topRatedMoviesResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)