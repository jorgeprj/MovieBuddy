package com.seuprojeto.mymovie.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(movieId: Int, onNavigateToHome: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Detalhes do Filme: $movieId")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToHome) {
                Text("Voltar para Home")
            }
        }
    }
}