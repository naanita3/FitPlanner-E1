package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.BICEPS.ejercicio019
import com.equno.fitplanner.BICEPS.ejercicio020
import com.equno.fitplanner.BICEPS.ejercicio021
import com.equno.fitplanner.BICEPS.ejercicio022
import com.equno.fitplanner.BICEPS.ejercicio023
import com.equno.fitplanner.BICEPS.ejercicio024
import com.equno.fitplanner.ESPALDA.ejercicio001
import com.equno.fitplanner.ESPALDA.ejercicio002
import com.equno.fitplanner.ESPALDA.ejercicio003
import com.equno.fitplanner.ESPALDA.ejercicio004
import com.equno.fitplanner.ESPALDA.ejercicio005
import com.equno.fitplanner.ESPALDA.ejercicio006
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

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
        //       ejerciciosSeleccionados.remove("Curl de bíceps predicador")
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

        val imgbtn19: ImageButton = findViewById(R.id.bicepsmancsupino)

        imgbtn19.setOnClickListener {
            val intent = Intent(this, ejercicio019::class.java)
            startActivity(intent)

        }

        val imgbtn20: ImageButton = findViewById(R.id.bicepsmartillo)

        imgbtn20.setOnClickListener {
            val intent = Intent(this, ejercicio020::class.java)
            startActivity(intent)

        }

        val imgbtn21: ImageButton = findViewById(R.id.bicepsbayesian)

        imgbtn21.setOnClickListener {
            val intent = Intent(this, ejercicio021::class.java)
            startActivity(intent)

        }

        val imgbtn22: ImageButton = findViewById(R.id.bicepspredicador)

        imgbtn22.setOnClickListener {
            val intent = Intent(this, ejercicio022::class.java)
            startActivity(intent)

        }

        val imgbtn23: ImageButton = findViewById(R.id.bicepspredmartillo)

        imgbtn23.setOnClickListener {
            val intent = Intent(this, ejercicio023::class.java)
            startActivity(intent)

        }

        val imgbtn24: ImageButton = findViewById(R.id.bicepsbarra)

        imgbtn24.setOnClickListener {
            val intent = Intent(this, ejercicio024::class.java)
            startActivity(intent)

        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (this.javaClass != MainMenu::class.java) {
                        val intent = Intent(this, MainMenu::class.java)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_explore -> {
                    if (this.javaClass != ExplorarEjercicios::class.java) {
                        val intent = Intent(this, ExplorarEjercicios::class.java)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_plan -> {
                    if (this.javaClass != ExplorarAlimentos::class.java) {
                        val intent = Intent(this, ExplorarAlimentos::class.java)
                        startActivity(intent)
                    }
                    true
                }// Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }




    }

}