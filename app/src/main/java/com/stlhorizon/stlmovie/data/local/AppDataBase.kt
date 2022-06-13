package com.stlhorizon.stlmovie.data.local



import androidx.room.Database
import androidx.room.RoomDatabase
import com.stlhorizon.stlmovie.data.local.data.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}