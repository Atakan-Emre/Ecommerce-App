package com.atakanemre.Ecommerce.model

data class RegisterBody(
    val address: String,
    val email: String,
    val name: String,
    val password: String,
    val phone: String
)