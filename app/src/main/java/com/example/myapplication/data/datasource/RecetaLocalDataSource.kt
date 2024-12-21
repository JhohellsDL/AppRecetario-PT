package com.example.myapplication.data.datasource

import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.local.FavoriteRecipeDao
import kotlinx.coroutines.flow.Flow

class RecetaLocalDataSource(private val dao: FavoriteRecipeDao) {

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> = dao.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) = dao.saveFavoriteRecipe(recipe)

    suspend fun removeFavoriteRecipe(recipe: FavoriteRecipe) = dao.removeFavoriteRecipe(recipe)

}
