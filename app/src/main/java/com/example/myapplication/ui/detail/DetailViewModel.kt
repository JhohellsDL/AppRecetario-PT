package com.example.myapplication.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.RecetaDomain
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getRecetasUseCase: GetRecetasUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state: StateFlow<DetailState> = _state

    fun loadRecetaById(id: Int) {
        viewModelScope.launch {
            _state.value = try {
                val receta = getRecetasUseCase.execute().find { it.id == id }
                if (receta != null) {
                    DetailState.Success(receta)
                } else {
                    DetailState.Error("Receta no encontrada")
                }
            } catch (e: Exception) {
                DetailState.Error("Error al cargar la receta")
            }
        }
    }
}

sealed class DetailState {
    object Loading : DetailState()
    data class Success(val receta: RecetaDomain) : DetailState()
    data class Error(val message: String) : DetailState()
}
