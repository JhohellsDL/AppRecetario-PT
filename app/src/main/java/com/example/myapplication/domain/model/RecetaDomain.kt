package com.example.myapplication.domain.model

import android.media.Image

data class RecetaDomain(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val isFavorite: Boolean = false
)
