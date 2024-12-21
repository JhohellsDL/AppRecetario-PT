package com.example.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey val recipeId: Int,
    val title: String,
    val shortDescription: String,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val duration: Int,
    val difficulty: Int,
    val image: String
)