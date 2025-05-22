package com.seuprojeto.mymovie.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDetails: (movieId: Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Tela Home - Filmes em Alta e Últimos Lançamentos")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToLogin) {
                Text("Voltar ao Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onNavigateToSearch) {
                Text("Ir para Pesquisa")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onNavigateToDetails(123) }) {
                Text("Ver Detalhes do Filme 123")
            }
        }
    }
}
