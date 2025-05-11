package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExplorarAlimentos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explora_alimentos)

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

        //BOTON PARA IR A VERDURAS
        val imgbtnVerduras: ImageButton = findViewById(R.id.verdurasbtn)

        imgbtnVerduras.setOnClickListener {
            val intent = Intent(this, PantallaVerduras::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A FRUTAS
        val imgbtnFrutas: ImageButton = findViewById(R.id.frutasbtn)

        imgbtnFrutas.setOnClickListener {
            val intent = Intent(this, PantallaFrutas::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A CARNES
        val imgbtnCarnes: ImageButton = findViewById(R.id.carnesbtn)

        imgbtnCarnes.setOnClickListener {
            val intent = Intent(this, PantallaCarnes::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A CEREALES
        val imgbtnCereales: ImageButton = findViewById(R.id.cerealesbtn)

        imgbtnCereales.setOnClickListener {
            val intent = Intent(this, PantallaCereales::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A LEGUMINOSAS
        val imgbtnLeguminosas: ImageButton = findViewById(R.id.leguminosasbtn)

        imgbtnLeguminosas.setOnClickListener {
            val intent = Intent(this, PantallaLeguminosas::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A GRASAS CON PROTE
        val imgbtnGrasascnprote: ImageButton = findViewById(R.id.grasasprotebtn)

        imgbtnGrasascnprote.setOnClickListener {
            val intent = Intent(this, PantallaGrasascnProte::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A GRASAS SIN PROTE
        val imgbtnGrasassinprote: ImageButton = findViewById(R.id.grasassinprotebtn)

        imgbtnGrasassinprote.setOnClickListener {
            val intent = Intent(this, PantallaGrassinprote::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR A LECHE Y DERIVADOS
        val imgbtnLeche: ImageButton = findViewById(R.id.lechebtn)

        imgbtnLeche.setOnClickListener {
            val intent = Intent(this, PantallaLacteos::class.java)
            startActivity(intent)
        }
    }

}