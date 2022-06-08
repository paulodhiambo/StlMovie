package com.stlhorizon.stlmovie.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.stlhorizon.stlmovie.R

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url == null) {
        Picasso.get().load(R.drawable.movie).into(this)
    } else {
        Picasso.get().load(url).into(this)
    }
}

fun showToast(context: Context, content: String) {
    Toast.makeText(context, content, Toast.LENGTH_LONG).show()
}


