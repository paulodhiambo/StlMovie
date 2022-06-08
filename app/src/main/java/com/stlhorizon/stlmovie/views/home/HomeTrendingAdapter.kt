package com.stlhorizon.stlmovie.views.home

import com.stlhorizon.stlmovie.R
import com.stlhorizon.stlmovie.data.local.data.Movie
import com.stlhorizon.stlmovie.databinding.HomeMovieItemBinding
import com.stlhorizon.stlmovie.utils.BaseRecyclerViewAdapter

class HomeTrendingAdapter : BaseRecyclerViewAdapter<Movie, HomeMovieItemBinding>() {
    override fun getLayout(): Int {
        return R.layout.home_movie_item
    }

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<HomeMovieItemBinding>,
        position: Int
    ) {
        holder.binding.movie = items[position]
        holder.binding.root.setOnClickListener {
            listener?.invoke(it, items[position], position)
        }
    }
}