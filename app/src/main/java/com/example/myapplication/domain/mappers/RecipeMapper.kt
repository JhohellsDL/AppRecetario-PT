package com.example.myapplication.domain.mappers

import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.model.RecetaResponse
import com.example.myapplication.domain.model.RecetaDomain


fun FavoriteRecipe.toDomain(): RecetaDomain {
    return RecetaDomain(
        id = recipeId,
        title = title,
        description = description,
        shortDescription = shortDescription,
        ingredients = ingredients,
        steps = steps,
        duration = duration,
        difficulty = difficulty,
        image = image,
        isFavorite = true
    )
}

fun RecetaResponse.toDomain(): RecetaDomain {
    return RecetaDomain(
        id = id,
        title = name,
        description = description,
        shortDescription = shortDescription,
        ingredients = ingredients,
        steps = steps,
        duration = duration,
        difficulty = difficulty,
        image = image,
        isFavorite = isFavorite
    )
}


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
