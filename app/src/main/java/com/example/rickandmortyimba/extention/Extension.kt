package com.example.rickandmortyimba.extention

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String){
    Glide.with(this)
        .load(uri)
        .into(this)
}