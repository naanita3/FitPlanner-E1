package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaEjerDiasM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dias_ejer_m)

        //*********BOTON DIA 1 MEDIO**********************************************************
        val btnDia1m = findViewById<Button>(R.id.button)

        btnDia1m.setOnClickListener {
            val intent = Intent(this, PantallaDia1m::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 2 MEDIO**********************************************************
        val btnDia2m = findViewById<Button>(R.id.button2)

        btnDia2m.setOnClickListener {
            val intent = Intent(this, PantallaDia2m::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 MEDIO**********************************************************
        val btnDia3m = findViewById<Button>(R.id.button3)

        btnDia3m.setOnClickListener {
            val intent = Intent(this, PantallaDia3m::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 MEDIO**********************************************************
        val btnDia4m = findViewById<Button>(R.id.button5)

        btnDia4m.setOnClickListener {
            val intent = Intent(this, PantallaDia4m::class.java)
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
                }

                R.id.navigation_routine -> {
                    if (this.javaClass != PantallaSelNivel::class.java) {
                        val intent = Intent(this, PantallaSelNivel::class.java)
                        startActivity(intent)
                    }
                    true
                }

                R.id.navigation_account -> {
                    if (this.javaClass != PantallaMiCuenta::class.java) {
                        val intent = Intent(this, PantallaMiCuenta::class.java)
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