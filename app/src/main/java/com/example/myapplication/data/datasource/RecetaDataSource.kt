package com.example.myapplication.data.datasource

import com.example.myapplication.data.RecetasList.recipes
import com.example.myapplication.data.model.Receta
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class RecetaDataSource {

    private val favoriteRecipes = MutableStateFlow<Set<Int>>(emptySet())

    suspend fun fetchRecipes(): List<Receta> = recipes

    suspend fun saveFavorites(favorites: Set<Int>) {
        favoriteRecipes.emit(favorites)
    }

    fun getFavoriteRecipesFlow(): Flow<Set<Int>> = favoriteRecipes

    fun getCurrentFavorites(): Set<Int> = favoriteRecipes.value
}
