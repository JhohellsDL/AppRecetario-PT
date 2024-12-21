package com.example.myapplication.data.datasource

import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.data.local.FavoriteRecipeDao
import com.example.myapplication.data.model.Receta
import com.example.myapplication.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class RecetaDataSource(private val dao: FavoriteRecipeDao) {

    fun getFavoriteRecipes(): Flow<List<FavoriteRecipe>> = dao.getFavoriteRecipes()

    suspend fun saveFavoriteRecipe(recipe: FavoriteRecipe) = dao.saveFavoriteRecipe(recipe)

    suspend fun fetchRecipes(): List<Receta> {
        return RetrofitInstance.api.getRecetas()
    }

}
