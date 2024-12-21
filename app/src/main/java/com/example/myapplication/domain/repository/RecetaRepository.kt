package com.example.myapplication.domain.repository

import com.example.myapplication.data.datasource.RecetaLocalDataSource
import com.example.myapplication.data.datasource.RecetaRemoteDataSource
import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.model.Receta
import kotlinx.coroutines.flow.Flow

class RecetaRepository(
    private val localDataSource: RecetaLocalDataSource,
    private val remoteDataSource: RecetaRemoteDataSource
) {

    suspend fun fetchRecipes(): List<Receta> {
        return remoteDataSource.fetchRecipes()
    }

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> = localDataSource.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) =
        localDataSource.saveFavoriteRecipe(recipe)

    suspend fun removeFavoriteRecipe(recipe: FavoriteRecipe) =
        localDataSource.removeFavoriteRecipe(recipe)

}