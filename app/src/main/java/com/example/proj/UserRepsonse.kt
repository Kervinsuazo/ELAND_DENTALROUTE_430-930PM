package com.example.dentistapp.model

data class UserResponse(
    val status: Boolean,
    val user: User
)

data class User(
    val id: Int,
    val name: String,
    val email: String
)
