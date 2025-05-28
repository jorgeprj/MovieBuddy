package com.example.moviebuddy.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.moviebuddy.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.moviebuddy.ui.components.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(movieId: Int, navController: NavHostController) {
    val context = LocalContext.current
    val factory = DetailsViewModelFactory(context, movieId)
    val viewModel: DetailsViewModel = viewModel(factory = factory)

    val movie by viewModel.movie.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.Details)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            movie?.let {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(it.fullPosterUrl),
                        contentDescription = it.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(it.title, style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.rating, it.vote_average.toString()),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(it.overview, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.toggleFavorite() }) {
                        Text(
                            text = stringResource(
                                id = if (isFavorite) R.string.remove_from_favorites else R.string.add_to_favorites
                            )
                        )
                    }
                }
            } ?: LoadingScreen()
        }
    }
}
