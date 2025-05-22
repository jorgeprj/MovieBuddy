package com.seuprojeto.mymovie.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Tela de Pesquisa")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToHome) {
                Text("Ir para Home")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onNavigateToLogin) {
                Text("Voltar ao Login")
            }
        }
    }
}
