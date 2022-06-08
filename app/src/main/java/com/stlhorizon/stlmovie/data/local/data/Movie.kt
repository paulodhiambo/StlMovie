package com.stlhorizon.stlmovie.data.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var title: String
)