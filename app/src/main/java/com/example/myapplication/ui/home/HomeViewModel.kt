package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Receta
import com.example.myapplication.data.repository.RecetaRepository
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import com.example.myapplication.domain.usecase.SaveRecetasFavoritasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val recetasUseCase: GetRecetasUseCase,
    private val saveRecetasUseCase: SaveRecetasFavoritasUseCase,
    private val getRecetasUseCase: GetRecetasUseCase
) : ViewModel() {

    private val _recetas = MutableStateFlow<List<RecetaDomain>>(emptyList())
    val recetas: StateFlow<List<RecetaDomain>> = _recetas.asStateFlow()

    private val _favorites = MutableStateFlow<Set<Int>>(emptySet())
    val favorites: StateFlow<Set<Int>> = _favorites.asStateFlow()

    init {
        loadRecetas()
        getFavoriteRecipes()
    }

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            getRecetasUseCase.execute().collect {
                println("jhohells Favorites: $it")
            }
        }
    }

    private fun loadRecetas() {
        viewModelScope.launch {
            recetasUseCase.execute().collect {
                _recetas.value = it
            }
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
            saveRecetasUseCase.execute(updatedFavorites)
        }
    }
}