package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaBrazo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_brazo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var imgbtn: ImageButton= findViewById(R.id.entrenamientotriceps)

        imgbtn.setOnClickListener {
            val intent = Intent(this, PantallaTriceps::class.java)
            startActivity(intent)
        }
        var imgbtn2: ImageButton= findViewById(R.id.entrenamientobicep)

        imgbtn2.setOnClickListener {
            val intent = Intent(this, PantallaBiceps::class.java)
            startActivity(intent)
        }
        var imgbtn3: ImageButton= findViewById(R.id.entrenamientohombro)

        imgbtn3.setOnClickListener {
            val intent = Intent(this, PantallaHombro::class.java)
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