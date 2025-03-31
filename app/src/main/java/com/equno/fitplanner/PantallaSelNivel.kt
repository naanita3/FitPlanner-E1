package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaSelNivel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_nivel)

        //*********BOTON DE PRINCIPIANTE**********************************************************
        val btnPrincipiante = findViewById<Button>(R.id.principiantebtn)

        btnPrincipiante.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasP::class.java)
            startActivity(intent)
        }


        //*********BOTON DE MEDIO**********************************************************
        val btnMedio = findViewById<Button>(R.id.mediobtn)

        btnMedio.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasM::class.java)
            startActivity(intent)
        }


        //*********BOTON DE AVANZADO**********************************************************
        val btnAvanzado = findViewById<Button>(R.id.avanzadobtn)

        btnAvanzado.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasA::class.java)
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

