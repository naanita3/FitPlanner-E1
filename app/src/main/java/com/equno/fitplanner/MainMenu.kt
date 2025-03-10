package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        val imgbtn : ImageButton = findViewById(R.id.entrenamientosP)

        imgbtn.setOnClickListener {
            val intent = Intent(this, ExplorarEjercicios::class.java)
            startActivity(intent)
        }

        // Busca el botón por su ID
        val btnMiRutina = findViewById<Button>(R.id.PantallaSelecEjer)

        // Configura el clic del botón
        btnMiRutina.setOnClickListener {
            // Crea un Intent para navegar a ActivitySetEjercicios
            val intent = Intent(this, ActivitySetEjercicios::class.java)
            startActivity(intent)
        }

        //*********BOTON DE PRINCIPIANTE**********************************************************
        val imgbtnrutPredef : ImageButton = findViewById(R.id.RutinasPredeterminadas)

        imgbtnrutPredef.setOnClickListener {
            val intent = Intent(this, PantallaSelNivel::class.java)
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
                // Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }
    }
}
