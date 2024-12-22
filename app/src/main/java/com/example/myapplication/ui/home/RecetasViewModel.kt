package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Receta
import com.example.myapplication.domain.usecase.GetRecetasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecetasViewModel(
    private val getRecetasUseCase: GetRecetasUseCase
) : ViewModel() {

    private var _recetas: MutableStateFlow<List<Receta>> = MutableStateFlow(emptyList())
    val recetas = _recetas.asStateFlow()

    init {
        loadRecetas()
    }

    private fun loadRecetas(){
        viewModelScope.launch {
            val recetas = getRecetasUseCase.execute()
            _recetas.value = recetas
        }
    }
}