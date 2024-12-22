package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.RecetaResponse
import com.example.myapplication.data.remote.RecetaApi

class RecetaRemoteDataSource(
    private val api: RecetaApi
) {

    suspend fun fetchRecipes(): List<RecetaResponse> {
        return api.getRecetas()
    }
}