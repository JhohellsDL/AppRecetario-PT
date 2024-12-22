package com.example.myapplication.ui.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(
    navController: NavHostController,
    recipeId: Int? = null
) {
    Text(text = "Detail Screen for recipeId: $recipeId")
}