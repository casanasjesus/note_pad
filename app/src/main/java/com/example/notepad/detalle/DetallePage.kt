package com.example.notepad.detalle

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.notepad.Nota

@Composable
fun DetallePage(
    navController: NavController,
    titulo: String,
    descripcion: String
) {
    val viewModel = viewModel {
        DetalleViewModel(
            nota = Nota(titulo, descripcion),
            navController = navController
        )
    }

    DetalleView(
        Modifier,
        estado = viewModel.estado
    ) { intencion ->
        viewModel.ejecutar(intencion)
    }
}