package com.example.myapplication.navigation

sealed class RecetasScreen(val route: String) {
    object Splash : RecetasScreen("splash")
    object Onboarding : RecetasScreen("onboarding")
    object Home : RecetasScreen("home")
    object Favorites : RecetasScreen("favorites")
}