package com.atakanemre.Ecommerce.util.extensions

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.atakanemre.Ecommerce.R

@SuppressLint("ResourceAsColor")
fun View.showSnackBar(message: String) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackBar.setTextColor(Color.WHITE)
    snackBar.setBackgroundTint(R.color.screen_background)
    snackBar.show()
}