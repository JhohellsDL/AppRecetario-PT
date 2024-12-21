package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.Receta
import com.example.myapplication.data.remote.RecetaApi

class RecetaRemoteDataSource(
    private val api: RecetaApi
) {

    suspend fun fetchRecipes(): List<Receta> {
        return api.getRecetas()
    }
}