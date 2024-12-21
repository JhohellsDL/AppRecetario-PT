package com.example.myapplication.domain.usecase

import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.repository.RecetaRepository

class SaveRecetasFavoritasUseCase(
    private val recetaRepository: RecetaRepository
) {
    suspend operator fun invoke(recipe: FavoriteRecipe) = recetaRepository.saveFavoriteRecipe(recipe)
}