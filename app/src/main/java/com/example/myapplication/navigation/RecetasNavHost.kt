package com.example.myapplication.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.home.HomeScreen
import com.example.myapplication.ui.onboarding.OnboardingScreen
import com.example.myapplication.ui.splash.SplashScreen

@Composable
fun RecetasNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RecetasScreen.Splash.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(route = RecetasScreen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = RecetasScreen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = RecetasScreen.Home.route) {
            HomeScreen()
        }
    }
}