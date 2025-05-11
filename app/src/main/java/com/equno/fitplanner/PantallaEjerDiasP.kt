package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaEjerDiasP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dias_ejer_p)

        //*********BOTON DIA 1 PRINCIPIANTE**********************************************************
        val btnDia1p = findViewById<Button>(R.id.button)

        btnDia1p.setOnClickListener {
            val intent = Intent(this, PantallaDia1p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 2 PRINCIPIANTE**********************************************************
        val btnDia2p = findViewById<Button>(R.id.button2)

        btnDia2p.setOnClickListener {
            val intent = Intent(this, PantallaDia2p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 PRINCIPIANTE**********************************************************
        val btnDia3p = findViewById<Button>(R.id.button3)

        btnDia3p.setOnClickListener {
            val intent = Intent(this, PantallaDia3p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 4 PRINCIPIANTE**********************************************************
        val btnDia4p = findViewById<Button>(R.id.button5)

        btnDia4p.setOnClickListener {
            val intent = Intent(this, PantallaDia4p::class.java)
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