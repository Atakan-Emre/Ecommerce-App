package com.atakanemre.Ecommerce.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.downloadFromUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}