package com.example.myapplication.data.repository

import com.example.myapplication.data.datasource.RecetaDataSource
import com.example.myapplication.data.model.Receta
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecetaRepository(private val dataSource: RecetaDataSource) {

    fun getAllRecetas(): Flow<List<Receta>> = flow {
        emit(dataSource.fetchRecipes())
    }

    suspend fun saveFavoritesRecetas(favorites: Set<Int>) {
        dataSource.saveFavorites(favorites)
    }

    fun getFavoriteRecipesFlow(): Flow<Set<Int>> = dataSource.getFavoriteRecipesFlow()

    fun getCurrentFavorites(): Set<Int> = dataSource.getCurrentFavorites()
}