package com.example.myapplication.utils

import androidx.navigation.NavController
import com.example.myapplication.navigation.RecetasScreen

fun navigateToDetail(navController: NavController, recipeId: Int, isFavorite: Boolean = false) {
    navController.navigate(RecetasScreen.Detail.createRoute(recipeId, isFavorite))
}
