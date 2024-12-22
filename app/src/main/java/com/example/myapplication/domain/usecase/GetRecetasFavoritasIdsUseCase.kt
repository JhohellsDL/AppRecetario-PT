package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.RecetaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRecetasFavoritasIdsUseCase(
    private val recetaRepository: RecetaRepository
) {
    fun execute(): Flow<List<Int>> {
        return recetaRepository.getFavoriteRecipes()
            .map { list -> list.map { it.recipeId } }
    }
}