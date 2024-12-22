package com.example.myapplication.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myapplication.ui.bottombar.RecetasNavigationBar
import com.example.myapplication.ui.detail.DetailScreen
import com.example.myapplication.ui.favorites.FavoritesScreen
import com.example.myapplication.ui.home.HomeScreen
import com.example.myapplication.ui.onboarding.OnboardingScreen
import com.example.myapplication.ui.splash.SplashScreen

@Composable
fun RecetasNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            if (isBottomNavVisible(navController = navController)) {
                RecetasNavigationBar(navController = navController)
            }
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RecetasScreen.Splash.route,
            modifier = modifier.fillMaxSize().padding(innerPadding)
        ) {
            composable(route = RecetasScreen.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(route = RecetasScreen.Onboarding.route) {
                OnboardingScreen(navController = navController)
            }
            composable(route = RecetasScreen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(route = RecetasScreen.Favorites.route) {
                FavoritesScreen(navController = navController)
            }
            composable(
                route = RecetasScreen.Detail.route,
                arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
            ) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getInt("recipeId")
                DetailScreen(navController = navController, recipeId = recipeId ?: 0)
            }

        }
    }
}

@Composable
fun isBottomNavVisible(navController: NavHostController): Boolean {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    return when (currentBackStackEntry?.destination?.route) {
        RecetasScreen.Home.route,
        RecetasScreen.Favorites.route -> true
        else -> false
    }
}
