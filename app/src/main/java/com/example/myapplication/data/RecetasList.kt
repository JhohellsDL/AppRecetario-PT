package com.example.myapplication.data

import com.example.myapplication.data.model.Receta

object RecetasList {
    val recipes = listOf(
        Receta(
            id = 1,
            name = "Spaghetti Bolognese",
            shortDescription = "A delicious spaghetti bolognese recipe",
            description = "A delicious spaghetti bolognese recipe that is quick and easy to make",
            ingredients = listOf("Spaghetti", "Bolognese sauce"),
            steps = listOf("Boil spaghetti", "Cook bolognese sauce", "Combine"),
            duration = 30,
            difficulty = 2,
            image = "spaghetti_bolognese.jpg"
        ),
        Receta(
            id = 2,
            name = "Chicken Curry",
            shortDescription = "A tasty chicken curry recipe",
            description = "A tasty chicken curry recipe that is full of flavor",
            ingredients = listOf("Chicken", "Curry sauce"),
            steps = listOf("Cook chicken", "Cook curry sauce", "Combine"),
            duration = 45,
            difficulty = 3,
            image = "chicken_curry.jpg"
        ),
        Receta(
            id = 3,
            name = "Vegetable Stir-fry",
            shortDescription = "A healthy vegetable stir-fry recipe",
            description = "A healthy vegetable stir-fry recipe that is packed with nutrients",
            ingredients = listOf("Vegetables", "Soy sauce"),
            steps = listOf("Stir-fry vegetables", "Add soy sauce", "Combine"),
            duration = 20,
            difficulty = 1,
            image = "vegetable_stir_fry.jpg"
        ),
        // Agrega más recetas aquí...
    )
}
