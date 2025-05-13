package com.example.notepad.detalle

import com.example.notepad.Nota

sealed class DetalleEstado {
    data object Vacio: DetalleEstado()
    data object Cargando: DetalleEstado()
    data class Error(val error:String): DetalleEstado()
    data class Resultado(val nota: Nota): DetalleEstado()
}