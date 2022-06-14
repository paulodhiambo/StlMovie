package com.stlhorizon.stlmovie.data.remote.response

import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.TopRatedMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie

data class MovieResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
){
    fun toMovie():PopularMovie{
        return PopularMovie(adult,backdrop_path,id,original_language,original_title,overview,popularity,poster_path,release_date,title,video,vote_average,vote_count)
    }

    fun toTopMovie():TopRatedMovie{
        return TopRatedMovie(adult,backdrop_path,id,original_language,original_title,overview,popularity,poster_path,release_date,title,video,vote_average,vote_count)
    }

    fun toUpcomingMovie():UpcomingMovie{
        return UpcomingMovie(adult,backdrop_path,id,original_language,original_title,overview,popularity,poster_path,release_date,title,video,vote_average,vote_count)
    }
}