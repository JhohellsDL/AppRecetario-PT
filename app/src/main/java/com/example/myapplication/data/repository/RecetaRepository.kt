package com.example.myapplication.data.repository

import com.example.myapplication.data.datasource.RecetaDataSource
import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.model.Receta
import kotlinx.coroutines.flow.Flow

class RecetaRepository(private val dataSource: RecetaDataSource) {

    suspend fun fetchRecipes(): List<Receta> {
        return dataSource.fetchRecipes()
    }

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> = dataSource.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) = dataSource.saveFavoriteRecipe(recipe)

}