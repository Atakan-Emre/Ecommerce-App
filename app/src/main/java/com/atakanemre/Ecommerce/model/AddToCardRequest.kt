package com.atakanemre.Ecommerce.model

data class AddToCardRequest(
    val userId: String,
    val productId: Int
)
