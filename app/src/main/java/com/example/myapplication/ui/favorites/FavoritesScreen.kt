package com.example.myapplication.ui.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.domain.mappers.toDomain
import com.example.myapplication.ui.components.RecipeItem
import com.example.myapplication.ui.home.FavoritesViewModel
import com.example.myapplication.utils.navigateToDetail
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    navController: NavHostController,
    viewModel: FavoritesViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadFavoriteRecipes()
    }

    val recipesFavorites: List<FavoriteRecipe> by viewModel.favoritesRecipes.collectAsState()

    LazyColumn {
        items(recipesFavorites.size) { index ->
            val receta = recipesFavorites[index].toDomain()
            RecipeItem(
                recipe = receta,
                isFavorite = false,
                onFavoriteToggle = { },
                onClickItem = {
                    navigateToDetail(navController, receta.id)
                }
            )

        }
    }
}