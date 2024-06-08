package com.atakanemre.Ecommerce.model

data class LoginResponse(
    val message: String,
    val status: Int,
    val userId: String
)