package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.Receta
import com.example.myapplication.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class RecetaDataSource {

    private val favoriteRecipes = MutableStateFlow<Set<Int>>(emptySet())

    suspend fun fetchRecipes(): List<Receta> {
        return RetrofitInstance.api.getRecetas()
    }

    suspend fun saveFavorites(favorites: Set<Int>) {
        favoriteRecipes.emit(favorites)
    }

    fun getFavoriteRecipesFlow(): Flow<Set<Int>> = favoriteRecipes

    fun getCurrentFavorites(): Set<Int> = favoriteRecipes.value
}
