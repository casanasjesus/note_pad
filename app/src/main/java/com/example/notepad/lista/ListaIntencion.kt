package com.example.notepad.lista

import com.example.notepad.Nota

sealed class ListaIntencion {
    object CargarLista: ListaIntencion()
    object NuevaNota: ListaIntencion()
    class NotaSeleccionada(val nota: Nota): ListaIntencion()
}