package com.example.notepad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetalleDeNotaView(
    navController: NavController,
    titulo: String,
    descripcion: String,
    modifier: Modifier = Modifier
) {
    Scaffold {
        Column (
            modifier = Modifier.padding(it)
        ) {
            Text(titulo)
            Text(descripcion)
        }
    }
}

@Composable
@Preview
fun DetalleDeNotaPreview() {
    val navController = rememberNavController()
    DetalleDeNotaView(navController, "", "")
}