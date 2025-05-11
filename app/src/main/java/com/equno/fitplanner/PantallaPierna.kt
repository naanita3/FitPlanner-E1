package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.PECHO.ejercicio007
import com.equno.fitplanner.PIERNA.ejercicio013
import com.equno.fitplanner.PIERNA.ejercicio014
import com.equno.fitplanner.PIERNA.ejercicio015
import com.equno.fitplanner.PIERNA.ejercicio016
import com.equno.fitplanner.PIERNA.ejercicio017
import com.equno.fitplanner.PIERNA.ejercicio018
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaPierna : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_pierna2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgbtn13: ImageButton = findViewById(R.id.curlsentado)

        imgbtn13.setOnClickListener {
            val intent = Intent(this, ejercicio013::class.java)
            startActivity(intent)
        }

        val imgbtn14: ImageButton = findViewById(R.id.curltumbado)

        imgbtn14.setOnClickListener {
            val intent = Intent(this, ejercicio014::class.java)
            startActivity(intent)
        }

        val imgbtn15: ImageButton = findViewById(R.id.swingpesasrusas)

        imgbtn15.setOnClickListener {
            val intent = Intent(this, ejercicio015::class.java)
            startActivity(intent)
        }

        val imgbtn16: ImageButton = findViewById(R.id.pesomuertorumano)

        imgbtn16.setOnClickListener {
            val intent = Intent(this, ejercicio016::class.java)
            startActivity(intent)
        }

        val imgbtn17: ImageButton = findViewById(R.id.quadextension)

        imgbtn17.setOnClickListener {
            val intent = Intent(this, ejercicio017::class.java)
            startActivity(intent)
        }

        val imgbtn18: ImageButton = findViewById(R.id.frontalsquat)

        imgbtn18.setOnClickListener {
            val intent = Intent(this, ejercicio018::class.java)
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