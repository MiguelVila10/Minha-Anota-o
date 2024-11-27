package com.miguelvilla.anotationmiguelVila.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miguelvilla.anotationmiguelVila.ui.database.NoteEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddClick: () -> Unit,
    onNoteClick: (Int) -> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Minhas anotações",
                        Modifier.fillMaxWidth(),
                        //textAlign = TextAlign.Center
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAddClick()
                }) {
                Icon(Icons.Default.Add, contentDescription = "Add new annotation")
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background,
            shadowElevation = 4.dp
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp),
            ) {
                items(uiState) { note ->
                    AnnotationItem(
                        note = note,
                        onDelete = {
                            viewModel.deleteNote(it)
                        },
                        onNoteClick = { onNoteClick(note.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun AnnotationItem(
    note: NoteEntity,
    onDelete: (Int) -> Unit,
    onNoteClick: (Int) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNoteClick(note.id) },
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = note.title, fontSize = 20.sp, color = Color.Black)
                IconButton(
                    onClick = { onDelete(note.id) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
            Text(
                text = note.description,
                fontSize = 17.sp,
                color = Color.Black
            )
            Text(
                text = note.date,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

}