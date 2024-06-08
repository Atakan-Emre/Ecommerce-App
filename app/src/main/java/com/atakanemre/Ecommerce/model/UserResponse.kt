package com.atakanemre.Ecommerce.model

data class UserResponse(
    val message: String,
    val status: Int,
    val user: User
)