package com.example.notepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notepad.detalle.DetallePage
import com.example.notepad.lista.ListaPage
import com.example.notepad.ui.theme.NotePadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotePadTheme {
                val navController = rememberNavController()
                val listaDeNotas = remember { mutableStateListOf<Nota>() }

                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ) {
                    composable("lista") {
                        ListaPage (
                            navController,
                            listaDeNotas
                        )
                    }
                    composable("nueva") {
                        NuevaNota(navController) { nota ->
                            listaDeNotas.add(nota)
                        }
                    }
                    composable("detalle/{titulo}/{descripcion}") { backStack ->
                        val titulo = backStack.arguments?.getString("titulo")
                        val descripcion = backStack.arguments?.getString("descripcion")

                        DetallePage(navController, titulo ?: "", descripcion ?: "")
                    }
                }
            }
        }
    }
}