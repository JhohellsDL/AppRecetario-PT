package com.example.myapplication.data.model

import com.example.myapplication.domain.model.RecetaDomain

data class Receta (
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val shortDescription: String = "",
    val ingredients: List<String> = emptyList(),
    val steps: List<String> = emptyList(),
    val duration: Int = 0,
    val difficulty: Int = 0,
    val image: String = "",
    val isFavorite: Boolean = false
)

fun Receta.toDomain(): RecetaDomain {
    return RecetaDomain(
        id = id,
        title = name,
        description = description,
        image = image,
        isFavorite = isFavorite
    )
}