package com.example.myapplication.domain.usecase

import com.example.myapplication.data.model.toDomain
import com.example.myapplication.data.repository.RecetaRepository
import com.example.myapplication.domain.model.RecetaDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRecetasUseCase(
    private val recetaRepository: RecetaRepository
) {
    fun execute(): Flow<List<RecetaDomain>> {
        return recetaRepository.getAllRecetas().map { recetas ->
            recetas.map {
                it.toDomain()
            }
        }
    }
}