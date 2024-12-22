package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.FavoriteRecipe
import com.example.myapplication.domain.mappers.toFavoriteRecipe
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.domain.usecase.GetRecetasFavoritasIdsUseCase
import com.example.myapplication.domain.usecase.GetRecetasFavoritasUseCase
import com.example.myapplication.domain.usecase.RemoveRecetasFavoritasUseCase
import com.example.myapplication.domain.usecase.SaveRecetasFavoritasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getRecetasFavoritasUseCase: GetRecetasFavoritasUseCase,
    private val saveRecetasFavoritasUseCase: SaveRecetasFavoritasUseCase,
    private val getRecetasFavoritasIdsUseCase: GetRecetasFavoritasIdsUseCase,
    private val removeRecetasFavoritasUseCase: RemoveRecetasFavoritasUseCase
) : ViewModel() {

    private val _favoritesRecipes = MutableStateFlow<List<FavoriteRecipe>>(emptyList())
    val favoritesRecipes: StateFlow<List<FavoriteRecipe>> = _favoritesRecipes.asStateFlow()

    private val _favorites = MutableStateFlow<Set<Int>>(emptySet())
    val favorites: StateFlow<Set<Int>> = _favorites.asStateFlow()

    fun toggleFavorite(recipeItem: RecetaDomain, recipeId: Int) {
        viewModelScope.launch {
            val updatedFavorites = _favorites.value.toMutableSet()
            val isFavorite = recipeId in updatedFavorites
            if (isFavorite) updatedFavorites.remove(recipeId) else updatedFavorites.add(recipeId)

            _favorites.value = updatedFavorites
            val favoriteRecipe = recipeItem.toFavoriteRecipe()
            handleFavoriteRecipe(favoriteRecipe, isFavorite)
        }
    }

    fun handleFavoriteRecipe(recipe: FavoriteRecipe, isFavorite: Boolean) {
        viewModelScope.launch {
            if (isFavorite) {
                removeRecetasFavoritasUseCase.invoke(recipe)
            } else {
                saveRecetasFavoritasUseCase.invoke(recipe)
            }
        }
    }

    init {
        loadFavoriteRecipesIds()
    }

    private fun loadFavoriteRecipesIds() {
        viewModelScope.launch {
            getRecetasFavoritasIdsUseCase.execute().collect {
                _favorites.value = it.toSet()
            }
        }
    }

    fun loadFavoriteRecipes() {
        viewModelScope.launch {
            getRecetasFavoritasUseCase.execute().collect {
                _favoritesRecipes.value = it
            }
        }
    }
}