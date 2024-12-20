package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.domain.model.RecetaDomain
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = koinViewModel()) {

    val recetas: List<RecetaDomain> by viewModel.recetas.collectAsState()
    val favoritos by viewModel.favorites.collectAsState()

    println("jhohells favoritos: $favoritos")

    LazyColumn {
        items(recetas.size) { index ->
            val receta = recetas[index]
            RecipeItem(
                recipe = receta,
                isFavorite = receta.id in favoritos,
                onFavoriteToggle = { viewModel.toggleFavorite(receta.id) }
            )

        }
    }
}

@Composable
fun RecipeItem(
    recipe: RecetaDomain,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = recipe.title,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onFavoriteToggle) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    RecipeItem(
        recipe = RecetaDomain(1, "asdfas d"),
        isFavorite = true,
        onFavoriteToggle = { }
    )
}
