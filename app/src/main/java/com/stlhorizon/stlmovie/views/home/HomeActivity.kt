package com.stlhorizon.stlmovie.views.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.stlhorizon.stlmovie.R
import com.stlhorizon.stlmovie.utils.Resource
import com.stlhorizon.stlmovie.views.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var fistShimmer:ShimmerFrameLayout
    lateinit var topRatedRecyclerView: RecyclerView
    private val viewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getTopRatedMovies()
        obsrveRsponse()
        fistShimmer = findViewById(R.id.shimmer_view_container_top_rated)
        fistShimmer.startShimmerAnimation()
        topRatedRecyclerView = findViewById(R.id.top_rated_recycler)

        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container_popular).startShimmerAnimation()
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container_upcoming).startShimmerAnimation()
        findViewById<ImageView>(R.id.searchm).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }

    fun obsrveRsponse(){
        viewModel.topRatedMoviesResponse.observe(this){result->
            when(result){
                is Resource.Success->{
                    Log.d("Result===>","${result.data}")
                    val madapter = TopRatedAdapter()
                    madapter.setMovies(result.data!!.results)
                    topRatedRecyclerView.apply {
                        hasFixedSize()
                        adapter =madapter
                        layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)

                    }
                    fistShimmer.visibility = View.GONE
                    topRatedRecyclerView.visibility =View.VISIBLE

                }
                is Resource.Loading->{}
                is Resource.Error->{}
            }
        }
    }
}