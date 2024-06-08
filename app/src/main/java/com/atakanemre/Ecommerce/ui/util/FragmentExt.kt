package com.atakanemre.Ecommerce.ui.util

import androidx.fragment.app.Fragment
import com.atakanemre.Ecommerce.util.extensions.showSnackBar

fun Fragment.showSnackBar(message: String) {
    requireView().showSnackBar(message)
}