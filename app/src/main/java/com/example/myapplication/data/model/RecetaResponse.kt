package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class RecetaResponse(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("title") val name: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("short_description") val shortDescription: String = "",
    @SerializedName("ingredients") val ingredients: List<String> = emptyList(),
    @SerializedName("steps") val steps: List<String> = emptyList(),
    @SerializedName("time") val duration: Int = 0,
    @SerializedName("difficulty") val difficulty: Int = 0,
    @SerializedName("image") val image: String = "",
    @SerializedName("is_favorite") val isFavorite: Boolean = false
)