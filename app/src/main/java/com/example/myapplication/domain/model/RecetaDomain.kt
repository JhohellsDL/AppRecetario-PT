package com.example.myapplication.domain.model

import com.example.myapplication.data.local.FavoriteRecipe

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

fun RecetaDomain.toFavoriteRecipe(): FavoriteRecipe {
    return FavoriteRecipe(
        recipeId = id,
        title = title,
        shortDescription = shortDescription,
        description = description,
        ingredients = ingredients,
        steps = steps,
        duration = duration,
        difficulty = difficulty,
        image = image
    )
}
