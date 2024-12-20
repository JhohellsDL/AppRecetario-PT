package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.RecetaRepository

class SaveRecetasFavoritasUseCase(
    private val recetaRepository: RecetaRepository
) {
    suspend fun execute(favorites: Set<Int>) {
        recetaRepository.saveFavoritesRecetas(favorites)
    }
}