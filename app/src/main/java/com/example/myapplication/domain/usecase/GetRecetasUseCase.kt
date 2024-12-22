package com.example.myapplication.domain.usecase

import com.example.myapplication.data.model.Receta
import com.example.myapplication.domain.repository.RecetaRepository

class GetRecetasUseCase(
    private val recetaRepository: RecetaRepository
) {
    suspend fun execute(): List<Receta> {
        return recetaRepository.fetchRecipes()
    }
}