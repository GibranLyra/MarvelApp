package com.gibran.marvelapp.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gibran.marvelapp.R

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.ic_android)
        .placeholder(R.drawable.ic_android)
        .into(this)
}