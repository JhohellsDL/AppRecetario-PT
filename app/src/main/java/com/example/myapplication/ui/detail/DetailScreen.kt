package com.example.myapplication.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import com.example.myapplication.domain.model.RecetaDomain

@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: DetailViewModel = koinViewModel(),
    recipeId: Int,
    isFavorite: Boolean = false
) {

    println("jhohells isFavorite_ $isFavorite")
    LaunchedEffect(recipeId) {
        viewModel.loadRecetaById(recipeId)
    }

    // Observar el estado de la receta
    val state by viewModel.state.collectAsState()

    // Mostrar contenido basado en el estado de la receta
    when (state) {
        is DetailState.Loading -> Text("Cargando receta...")
        is DetailState.Success -> RecetaContent(receta = (state as DetailState.Success).receta)
        is DetailState.Error -> Text((state as DetailState.Error).message)
    }
}

@Composable
fun RecetaContent(receta: RecetaDomain) {
    // Composable para mostrar el contenido de la receta
    Column {
        Text(text = "Detail Screen for recipeId: ${receta.id}")
        Text(text = "Receta: ${receta.title}")
        Text(text = "Descripción: ${receta.description}")
    }
}
