package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.RecetaRepository

class GetRecetasFavoritasUseCase(
    private val recetaRepository: RecetaRepository
) {
    fun execute() = recetaRepository.getFavoriteRecipesFlow()
}