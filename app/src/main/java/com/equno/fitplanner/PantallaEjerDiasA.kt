package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaEjerDiasA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dias_ejer_a)

        //*********BOTON DIA 1 AVANZADO**********************************************************
        val btnDia1a = findViewById<Button>(R.id.button)

        btnDia1a.setOnClickListener {
            val intent = Intent(this, PantallaDia1a::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 2 AVANZADO**********************************************************
        val btnDia2a = findViewById<Button>(R.id.button2)

        btnDia2a.setOnClickListener {
            val intent = Intent(this, PantallaDia2a::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 AVANZADO**********************************************************
        val btnDia3a = findViewById<Button>(R.id.button3)

        btnDia3a.setOnClickListener {
            val intent = Intent(this, PantallaDia3a::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 AVANZADO**********************************************************
        val btnDia4a = findViewById<Button>(R.id.button5)

        btnDia4a.setOnClickListener {
            val intent = Intent(this, PantallaDia4a::class.java)
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