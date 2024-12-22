package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.mappers.toDomain
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.domain.repository.RecetaRepository

class GetRecetasUseCase(
    private val recetaRepository: RecetaRepository
) {
    suspend fun execute(): List<RecetaDomain> {
        return recetaRepository.fetchRecipes().map { it.toDomain() }
    }
}