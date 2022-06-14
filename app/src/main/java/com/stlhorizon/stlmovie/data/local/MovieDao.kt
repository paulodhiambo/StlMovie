package com.stlhorizon.stlmovie.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.TopRatedMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie

@Dao
interface MovieDao {
    @Insert
    suspend fun save(movie : PopularMovie)
    @Insert
    suspend fun save(movie : TopRatedMovie)
    @Insert
    suspend fun save(movie : UpcomingMovie)

    @Query("SELECT * FROM popularmovie")
    suspend fun getPopularMovies(): List<PopularMovie>

    @Query("SELECT * FROM topratedmovie")
    suspend fun getTopRatedMovies(): List<TopRatedMovie>

    @Query("SELECT * FROM upcomingmovie")
    suspend fun getMovies(): List<UpcomingMovie>
}