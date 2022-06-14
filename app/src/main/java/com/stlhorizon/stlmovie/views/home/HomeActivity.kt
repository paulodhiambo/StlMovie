package com.stlhorizon.stlmovie.views.home

import android.content.Intent
import android.os.Bundle
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
    lateinit var topRatedShimmer:ShimmerFrameLayout
    lateinit var popularShimmer:ShimmerFrameLayout
    lateinit var upcomingShimmer:ShimmerFrameLayout
    lateinit var topRatedRecyclerView: RecyclerView
    lateinit var upcomingRecyclerView: RecyclerView
    lateinit var popularRecyclerView: RecyclerView

    private val viewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getTopRatedMovies()
        viewModel.getPopularMovies()
        viewModel.getUpcomingMovies()
        obsrveRsponse()
        obsrvePopular()
        obsrveUpcoming()
        topRatedShimmer = findViewById(R.id.shimmer_view_container_top_rated)
        topRatedShimmer.startShimmerAnimation()
        topRatedRecyclerView = findViewById(R.id.top_rated_recycler)

        popularShimmer = findViewById(R.id.shimmer_view_container_popular)
        popularShimmer.startShimmerAnimation()
        popularRecyclerView = findViewById(R.id.popular_recycler)

        upcomingShimmer = findViewById(R.id.shimmer_view_container_upcoming)
        upcomingShimmer.startShimmerAnimation()
        upcomingRecyclerView = findViewById(R.id.upcoming_recycler)

        findViewById<ImageView>(R.id.searchm).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }

    fun obsrveRsponse(){
        viewModel.topRatedMoviesResponse.observe(this){result->
            when(result){
                is Resource.Success->{
                    val madapter = TopRatedAdapter()
                    madapter.setMovies(result.data!!)
                    topRatedRecyclerView.apply {
                        hasFixedSize()
                        adapter =madapter
                        layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)

                    }
                    topRatedShimmer.visibility = View.GONE
                    topRatedRecyclerView.visibility =View.VISIBLE

                }
                is Resource.Loading->{}
                is Resource.Error->{}
            }
        }
    }

    fun obsrveUpcoming(){
        viewModel.upcomingMoviesResponse.observe(this){result->
            when(result){
                is Resource.Success->{
                    val madapter = UpcomingAdapter()
                    madapter.setMovies(result.data!!)
                    upcomingRecyclerView.apply {
                        hasFixedSize()
                        adapter =madapter
                        layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)

                    }
                    upcomingShimmer.visibility = View.GONE
                    upcomingRecyclerView.visibility =View.VISIBLE

                }
                is Resource.Loading->{}
                is Resource.Error->{}
            }
        }
    }
    fun obsrvePopular(){
        viewModel.popularMoviesResponse.observe(this){result->
            when(result){
                is Resource.Success->{
                    val madapter = PopularAdapter()
                    madapter.setMovies(result.data!!)
                    popularRecyclerView.apply {
                        hasFixedSize()
                        adapter =madapter
                        layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)

                    }
                    popularShimmer.visibility = View.GONE
                    popularRecyclerView.visibility =View.VISIBLE

                }
                is Resource.Loading->{}
                is Resource.Error->{}
            }
        }
    }
}