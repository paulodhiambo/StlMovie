package com.stlhorizon.stlmovie.views.home

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.facebook.shimmer.ShimmerFrameLayout
import com.stlhorizon.stlmovie.R
import com.stlhorizon.stlmovie.views.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container_popular).startShimmerAnimation()
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container_top_rated).startShimmerAnimation()
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container_upcoming).startShimmerAnimation()
        findViewById<ImageView>(R.id.searchm).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}