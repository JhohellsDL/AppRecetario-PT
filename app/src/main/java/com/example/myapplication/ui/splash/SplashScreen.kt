package com.example.myapplication.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.DataStoreManager
import com.example.myapplication.navigation.RecetasScreen
import kotlinx.coroutines.delay
import org.koin.compose.getKoin

@Composable
fun SplashScreen(
    navController: NavHostController,
    dataStoreManager: DataStoreManager = getKoin().get()
) {

    val onboardingCompleted by dataStoreManager.onboardingCompletedFlow
        .collectAsState(initial = false)

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(
            if (onboardingCompleted) RecetasScreen.Home.route
            else RecetasScreen.Onboarding.route
        ) {
            popUpTo(RecetasScreen.Splash.route) { inclusive = true }
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "SPLASH SCREEN - Recetario APP")
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
