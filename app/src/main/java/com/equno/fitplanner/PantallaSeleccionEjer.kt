package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class PantallaSeleccionEjer : AppCompatActivity() {

    // Lista para almacenar los ejercicios seleccionados
    private val ejerciciosSeleccionados = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_ejercicios)

        // Obtener la lista de ejercicios seleccionados
        val pantallaBiceps = intent.getStringArrayListExtra("ejerciciosSeleccionados")

        // Mostrar los ejercicios seleccionados
        val listaEjercicios = findViewById<TextView>(R.id.listaEjercicios)
        if (ejerciciosSeleccionados != null && ejerciciosSeleccionados.isNotEmpty()) {
            val ejerciciosTexto = ejerciciosSeleccionados.joinToString("\n")
            listaEjercicios.text = "Ejercicios seleccionados:\n$ejerciciosTexto"
        } else {
            listaEjercicios.text = "No has seleccionado ningún ejercicio."
        }
    }
}
