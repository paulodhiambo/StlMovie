package com.stlhorizon.stlmovie.data.local



import androidx.room.Database
import androidx.room.RoomDatabase
import com.stlhorizon.stlmovie.data.remote.response.Movie

@Database(entities = [Movie::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}