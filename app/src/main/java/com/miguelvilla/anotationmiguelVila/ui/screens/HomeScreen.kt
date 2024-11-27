package com.miguelvilla.anotationmiguelVila.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onAddClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF1E88E5), // Azul vibrante para o topo
                    titleContentColor = Color.White, // Contraste do texto no topo
                ),
                title = {
                    Text(
                        text = "Minhas Anotações MV",
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddClick() },
                containerColor = Color(0xFFFFC107), // Amarelo vibrante
                contentColor = Color.Black
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add new annotation")
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color(0xFFF5F5F5), // Fundo claro neutro
            shadowElevation = 4.dp
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp),
            ) {
                items(8) { index ->
                    AnnotationItem(index = index)
                }
            }
        }
    }
}

@Composable
fun AnnotationItem(index: Int) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Color(0xFFE3F2FD)) // Azul claro para cartões
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Annotation $index", fontSize = 20.sp, color = Color(0xFF0D47A1)) // Azul escuro para título
            Text(
                text = "Lorem ipsum of annotation $index \n sada",
                fontSize = 17.sp,
                color = Color(0xFF424242) // Cinza-escuro para texto secundário
            )
            Text(
                text = "19/11/2024",
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                color = Color(0xFF757575), // Cinza médio para data
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onAddClick = {})
}
