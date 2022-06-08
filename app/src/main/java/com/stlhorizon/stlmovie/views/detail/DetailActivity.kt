package com.stlhorizon.stlmovie.views.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stlhorizon.stlmovie.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}