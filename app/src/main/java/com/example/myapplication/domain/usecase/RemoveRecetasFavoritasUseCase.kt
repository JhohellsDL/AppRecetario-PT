package com.example.myapplication.domain.usecase

import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.domain.repository.RecetaRepository

class RemoveRecetasFavoritasUseCase(
    private val recetaRepository: RecetaRepository
) {
    suspend operator fun invoke(recipe: FavoriteRecipe) =
        recetaRepository.removeFavoriteRecipe(recipe)
}