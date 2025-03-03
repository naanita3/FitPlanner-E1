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
    }
}

class PantallaSeleccionEjer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_ejercicios)

        // Referencia al botón
        val btnMiRutina = findViewById<Button>(R.id.PantallaMiRutina)

        // Configurar el clic del botón
        btnMiRutina.setOnClickListener {
            // Crear un Intent para navegar a SelEjerciciosActivity
            val intent = Intent(this, PantallaSeleccionEjer::class.java)
            startActivity(intent)
        }
    }
}
