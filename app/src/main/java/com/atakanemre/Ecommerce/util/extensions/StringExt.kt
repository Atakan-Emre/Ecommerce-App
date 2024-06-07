package com.atakanemre.Ecommerce.util.extensions

fun String?.orDefault(default: String): String {
    return this ?: default
}