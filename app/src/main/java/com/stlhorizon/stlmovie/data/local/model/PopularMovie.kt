package com.stlhorizon.stlmovie.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PopularMovie(
    val adult: Boolean,
    val backdrop_path: String,
    @PrimaryKey(autoGenerate = false)
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
    val vote_count: Int,
)