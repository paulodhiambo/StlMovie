package com.stlhorizon.stlmovie.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stlhorizon.stlmovie.data.remote.response.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun save(movie : Movie)

    @Query("SELECT * FROM movie")
    suspend fun getMovies(): List<Movie>
}