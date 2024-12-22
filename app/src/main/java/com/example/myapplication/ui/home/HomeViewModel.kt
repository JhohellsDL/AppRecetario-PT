package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.model.RecetaDomain

class HomeViewModel(
    private val recetasViewModel: RecetasViewModel,
    private val favoritesViewModel: FavoritesViewModel
) : ViewModel() {

    val recetas = recetasViewModel.recetas
    val favorites = favoritesViewModel.favorites

    fun toggleFavorite(recipeId: Int) {
        val recipe = recetas.value.find { it.id == recipeId } ?: RecetaDomain()
        favoritesViewModel.toggleFavorite(recipe, recipeId)
    }

}