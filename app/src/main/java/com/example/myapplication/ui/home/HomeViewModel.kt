package com.example.myapplication.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.domain.usecase.GetRecetasFavoritasUseCase
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import com.example.myapplication.domain.usecase.SaveRecetasFavoritasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val recetasUseCase: GetRecetasUseCase,
    private val saveRecetasUseCase: SaveRecetasFavoritasUseCase,
    private val getRecetasUseCase: GetRecetasFavoritasUseCase
) : ViewModel() {

    private val _recetas = MutableStateFlow<List<RecetaDomain>>(emptyList())
    val recetas: StateFlow<List<RecetaDomain>> = _recetas.asStateFlow()

    private val _favorites = MutableStateFlow<Set<Int>>(emptySet())
    val favorites: StateFlow<Set<Int>> = _favorites.asStateFlow()

    init {
        loadRecetas()
        //getFavoriteRecipes()
        //saveRecipe()
    }

    private fun loadRecetas() {
        viewModelScope.launch {
            // Cargar recetas desde el caso de uso
            recetasUseCase.execute().let {
                Log.d("jhohells", "Fetched Recipes: $it")
                _recetas.value = it
            }

            // Obtener recetas favoritas y almacenarlas
            getRecetasUseCase.execute().collect { favorites ->
                Log.d("jhohells", "Fetched Favorite Recipes: $favorites")
            }
        }
    }

    fun saveRecipe() {
        val recipe = FavoriteRecipe(
            recipeId = 1,
            title = "Spaghetti Bolognese",
            shortDescription = "Delicious pasta",
            description = "A classic Italian dish...",
            ingredients = listOf("Spaghetti", "Tomato Sauce", "Ground Beef"),
            steps = listOf("Boil spaghetti", "Cook sauce", "Combine and serve"),
            duration = 30,
            difficulty = 2,
            image = "spaghetti_bolognese.jpg"
        )

        viewModelScope.launch {
            saveRecetasUseCase(recipe)
        }
    }

    fun toggleFavorite(recipeId: Int) {
        viewModelScope.launch {
            val updatedFavorites = _favorites.value.toMutableSet()
            if (recipeId in updatedFavorites) {
                updatedFavorites.remove(recipeId)
            } else {
                updatedFavorites.add(recipeId)
            }
            _favorites.value = updatedFavorites
        }
    }
}