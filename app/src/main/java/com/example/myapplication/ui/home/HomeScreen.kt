package com.example.myapplication.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.navigation.RecetasScreen
import com.example.myapplication.ui.components.RecipeItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {

    val recetas: List<RecetaDomain> by viewModel.recetas.collectAsState()
    val favoritos by viewModel.favorites.collectAsState()

    LazyColumn {
        items(recetas.size) { index ->
            val receta = recetas[index]
            RecipeItem(
                recipe = receta,
                isFavorite = receta.id in favoritos,
                onFavoriteToggle = {
                    viewModel.toggleFavorite(receta.id)
                },
                onClickItem = {
                    navController.navigate("${RecetasScreen.Detail.route}/${receta.id}")
                }
            )
        }
    }
}
