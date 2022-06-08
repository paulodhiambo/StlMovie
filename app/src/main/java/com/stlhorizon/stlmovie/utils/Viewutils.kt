package com.stlhorizon.stlmovie.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(view)
}

fun showToast(context: Context, content: String) {
    Toast.makeText(context, content, Toast.LENGTH_LONG).show()
}
