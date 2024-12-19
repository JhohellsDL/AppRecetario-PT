package com.example.myapplication.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.RecetasScreen
import com.example.myapplication.ui.onboarding.OnboardingViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(navController: NavHostController, onboardingViewModel: OnboardingViewModel = koinViewModel() ) {

    val onboardingCompleted: Boolean = onboardingViewModel.onboardingCompleted.collectAsState(initial = false).value
    LaunchedEffect(Unit) {
        delay(2000)
        if (onboardingCompleted){
            navController.navigate(RecetasScreen.Home.route)
        }else{
            navController.navigate(RecetasScreen.Onboarding.route)
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
