package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.model.RecetaDomain

@Composable
fun RecipeItem(
    recipe: RecetaDomain,
    isFavorite: Boolean,
    onFavoriteToggle: () -> Unit,
    onClickItem: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = recipe.title,
            modifier = Modifier.weight(1f).clickable { onClickItem() }
        )
        IconButton(onClick = onFavoriteToggle) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites"
            )
        }
    }
}

@Preview
@Composable
fun RecipeItemPreview() {
    RecipeItem(
        recipe = RecetaDomain(1, "Recipe title"),
        isFavorite = true,
        onFavoriteToggle = { },
        onClickItem = { }
    )
}
