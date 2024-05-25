package com.atakanemre.Ecommerce.model

data class Product(
    val message: String,
    val products: List<ProductX>?,
    val status: Int
)