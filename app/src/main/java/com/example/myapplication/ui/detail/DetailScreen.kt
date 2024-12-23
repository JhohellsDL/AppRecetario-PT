package com.example.myapplication.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.domain.model.RecetaDomain
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: DetailViewModel = koinViewModel(),
    recipeId: Int,
    isFavorite: Boolean = false
) {

    LaunchedEffect(recipeId) {
        viewModel.loadRecetaById(recipeId)
    }

    val state by viewModel.state.collectAsState()

    when (state) {
        is DetailState.Loading -> Text("Cargando receta...")
        is DetailState.Success -> RecetaContent(receta = (state as DetailState.Success).receta, navController = navController)
        is DetailState.Error -> Text((state as DetailState.Error).message)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecetaContent(receta: RecetaDomain, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = receta.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción aquí */ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Acciones"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            if (false) {
                Image(
                    painter = rememberAsyncImagePainter(receta.image),
                    contentDescription = "Imagen de la receta",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.food_vegetable),
                    contentDescription = "Imagen de la receta",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Descripción:",
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
            Text(
                text = receta.description,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
            )

            RecetaDetailSection(
                title = "Ingredientes",
                items = receta.ingredients
            )
            RecetaDetailSection(
                title = "Pasos",
                items = receta.steps
            )

        }
    }

}

@Composable
fun RecetaDetailSection(title: String, items: List<String>) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        items.forEach { item ->
            Text(
                text = "• $item",
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    RecetaContent(
        receta = RecetaDomain(
            id = 1,
            title = "Receta de prueba",
            description = "Descripción de la receta de prueba",
            ingredients = listOf("Ingrediente 1", "Ingrediente 2"),
            steps = listOf("Paso 1", "Paso 2"),
        ),
        rememberNavController()
    )
}
