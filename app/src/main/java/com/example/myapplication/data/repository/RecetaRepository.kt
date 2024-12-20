package com.example.myapplication.data.repository

import com.example.myapplication.data.datasource.RecetaDataSource
import com.example.myapplication.data.model.Receta
import kotlinx.coroutines.flow.Flow

class RecetaRepository(private val dataSource: RecetaDataSource) {

    suspend fun fetchRecipes(): List<Receta> {
        return dataSource.fetchRecipes()
    }

    suspend fun saveFavoritesRecetas(favorites: Set<Int>) {
        dataSource.saveFavorites(favorites)
    }

    fun getFavoriteRecipesFlow(): Flow<Set<Int>> = dataSource.getFavoriteRecipesFlow()

    fun getCurrentFavorites(): Set<Int> = dataSource.getCurrentFavorites()
}