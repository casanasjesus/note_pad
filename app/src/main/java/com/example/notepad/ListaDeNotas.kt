package com.example.notepad

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeNotasView(
    navController: NavController,
    listaDeNotas: List<Nota>,
    modifier: Modifier = Modifier,
) {
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
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(15.dp)
        ) {
            items(listaDeNotas) { nota ->
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                navController.navigate("detalle/${nota.titulo}/${nota.descripcion}")
                            }
                        )
                ) {
                    Column(
                      verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(top = 10.dp),
                            text = nota.titulo,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(top = 10.dp),
                            text = nota.descripcion,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(
                    modifier
                        .height(15.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaDeNotasPreview() {
    val list = listOf<Nota>()

    NotePadTheme {
        ListaDeNotasView(
            rememberNavController(),
            list
        )
    }
}