package com.example.testshop.domain.model.users

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String?
)
