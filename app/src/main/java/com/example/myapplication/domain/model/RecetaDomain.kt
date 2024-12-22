package com.example.myapplication.domain.model

data class RecetaDomain(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val shortDescription: String = "",
    val ingredients: List<String> = emptyList(),
    val steps: List<String> = emptyList(),
    val duration: Int = 0,
    val difficulty: Int = 0,
    val image: String = "",
    val isFavorite: Boolean = false
)
