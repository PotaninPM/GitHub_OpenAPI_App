package com.example.hselyceumapp.domain.model

data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val is_favorite: Int
)
