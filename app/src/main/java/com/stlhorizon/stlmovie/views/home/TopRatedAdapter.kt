package com.stlhorizon.stlmovie.views.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stlhorizon.stlmovie.R
import com.stlhorizon.stlmovie.data.remote.response.Movie
import com.stlhorizon.stlmovie.views.detail.DetailActivity

class TopRatedAdapter : RecyclerView.Adapter<TopRatedAdapter.ViewHolder>(){
    private var movies : MutableList<Movie> = ArrayList()
    fun setMovies(items:List<Movie>){
        movies.addAll(items)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(movie:Movie){
            val image = itemView.findViewById<ImageView>(R.id.movie_card)
            Picasso.get().load("https://image.tmdb.org/t/p/w500${movie.backdrop_path}").into(image)
            Log.d("image Url =====>", "https://image.tmdb.org/t/p/w500${movie.backdrop_path}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_movie_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context, DetailActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}