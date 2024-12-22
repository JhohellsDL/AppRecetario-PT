package com.example.myapplication.navigation

sealed class RecetasScreen(val route: String) {
    object Splash : RecetasScreen("splash")
    object Onboarding : RecetasScreen("onboarding")
    object Home : RecetasScreen("home")
    object Favorites : RecetasScreen("favorites")
    object Detail : RecetasScreen("detail/{recipeId}/{isFavorite}") {
        fun createRoute(recipeId: Int, isFavorite: Boolean): String = "detail/$recipeId/$isFavorite"
    }
}