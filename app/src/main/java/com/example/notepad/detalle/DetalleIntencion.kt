package com.example.notepad.detalle

sealed class DetalleIntencion {
    object CargarContenido: DetalleIntencion()
    object IrParaAtras: DetalleIntencion()
}