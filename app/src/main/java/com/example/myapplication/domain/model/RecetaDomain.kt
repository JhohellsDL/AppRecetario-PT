package com.example.myapplication.domain.model

data class RecetaDomain(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val isFavorite: Boolean = false
)
