package com.example.myapplication.navigation

sealed class RecetasScreen(val route: String) {
    object Splash : RecetasScreen("splash")
    object Home : RecetasScreen("home")
}