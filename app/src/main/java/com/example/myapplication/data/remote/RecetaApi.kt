package com.example.myapplication.data.remote

import com.example.myapplication.data.model.RecetaResponse
import retrofit2.http.GET

interface RecetaApi {

    @GET("/recipes")
    suspend fun getRecetas(): List<RecetaResponse>

}