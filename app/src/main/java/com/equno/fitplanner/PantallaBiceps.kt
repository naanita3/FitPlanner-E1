package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PantallaBiceps : AppCompatActivity() {

    // Lista para almacenar los ejercicios seleccionados
    private val ejerciciosSeleccionados = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_biceps)

        // **********************************************
        // Código del punto 2: Selección de ejercicios
        // **********************************************

        // Configurar los CheckBox para cada ejercicio
        //val checkBox8 = findViewById<CheckBox>(R.id.checkBox8)
        //val checkBox11 = findViewById<CheckBox>(R.id.checkBox11)
        //val checkBox12 = findViewById<CheckBox>(R.id.checkBox12)
        //val checkBox13 = findViewById<CheckBox>(R.id.checkBox13)
        //val checkBox14 = findViewById<CheckBox>(R.id.checkBox14)
        //val checkBox15 = findViewById<CheckBox>(R.id.checkBox15)
        // Repite para los otros ejercicios...

        // Manejar la selección de ejercicios - CHECKBOX 8
        //checkBox8.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {
        ////    } else {
        //        ejerciciosSeleccionados.remove("Curl de bíceps con mancuernas")
            //}
        //}

        // Manejar la selección de ejercicios - CHECKBOX 11
        //checkBox11.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {
        //        ejerciciosSeleccionados.add("Curl de bíceps con mancuernas")
        //    } else {
        //        ejerciciosSeleccionados.remove("Curl de bíceps martillo con mancuernas")
        //    }
        //}

        // Manejar la selección de ejercicios - CHECKBOX 12
        //checkBox12.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {
        //        ejerciciosSeleccionados.add("Curl de bíceps con mancuernas")
        ////        ejerciciosSeleccionados.remove("Curl de bíceps bayesian")
        //    }
        //}

        // Manejar la selección de ejercicios - CHECKBOX 13
        //checkBox13.setOnCheckedChangeListener { _, isChecked ->
       //     if (isChecked) {
       //     } else {
        //        ejerciciosSeleccionados.remove("Curl de bíceps predicador")
        //    }
        //}

        // Manejar la selección de ejercicios - CHECKBOX 14
        //checkBox14.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {
        //        ejerciciosSeleccionados.add("Curl de bíceps con mancuernas")
        //    } else {
        //        ejerciciosSeleccionados.remove("Curl de bíceps predicador")
        //    }
        //}

        // Manejar la selección de ejercicios - CHECKBOX 15
        //checkBox15.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {
        //        ejerciciosSeleccionados.add("Curl de bíceps con mancuernas")
        //    } else {
        //        ejerciciosSeleccionados.remove("Curl de bíceps con barra z")
        //    }
       //}
        // Repite para los otros ejercicios...

        // Botón para ir a la pantalla de selección
        //val botonVerSeleccion = findViewById<Button>(R.id.botonVerSeleccion)
        //botonVerSeleccion.setOnClickListener {
        //    val intent = Intent(this, PantallaSeleccionEjer::class.java)
        //     startActivity(intent)
        //}
    }
}