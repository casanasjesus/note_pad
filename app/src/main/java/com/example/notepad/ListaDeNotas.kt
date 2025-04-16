package com.example.notepad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notepad.ui.theme.NotePadTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeNotasView(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("NotePadApp")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("nueva")
                }
            ) {
               Icon(
                   imageVector = Icons.Filled.Add,
                   contentDescription = "Agregar"
               )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Text("Soy una lista de notas")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaDeNotasPreview() {
    NotePadTheme {
        ListaDeNotasView(
            rememberNavController()
        )
    }
}