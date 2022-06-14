package com.stlhorizon.stlmovie.data.local



import androidx.room.Database
import androidx.room.RoomDatabase
import com.stlhorizon.stlmovie.data.local.model.PopularMovie
import com.stlhorizon.stlmovie.data.local.model.TopRatedMovie
import com.stlhorizon.stlmovie.data.local.model.UpcomingMovie

@Database(entities = [PopularMovie::class,TopRatedMovie::class,UpcomingMovie::class], version = 8 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}