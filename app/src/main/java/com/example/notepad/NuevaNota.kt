package com.example.notepad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notepad.ui.theme.NotePadTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaNota(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNuevaNota: (Nota) -> Unit
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
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            var titulo by remember { mutableStateOf("") }
            var descripcion by remember { mutableStateOf("") }

            Text("Ingresar título")
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = titulo,
                label = {
                    Text("Ingresar texto")
                },
                onValueChange = { texto ->
                    titulo = texto
                }
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text("Ingresar texto")
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                value = descripcion,
                label = {
                    Text("Ingresar texto")
                },
                onValueChange = { texto ->
                    descripcion = texto
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                    onNuevaNota(
                        Nota(
                            titulo = titulo,
                            descripcion = descripcion
                        )
                    )
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Crear nota")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NuevaNotaPreview() {
    NotePadTheme {
        NuevaNota(
            rememberNavController()
        ){ _ -> }
    }
}
