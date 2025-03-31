package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.ESPALDA.ejercicio001
import com.equno.fitplanner.PECHO.ejercicio007
import com.equno.fitplanner.PECHO.ejercicio008
import com.equno.fitplanner.PECHO.ejercicio009
import com.equno.fitplanner.PECHO.ejercicio010
import com.equno.fitplanner.PECHO.ejercicio011
import com.equno.fitplanner.PECHO.ejercicio012
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaPectoral : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_pectoral)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgbtn7: ImageButton = findViewById(R.id.pressbancapecho)

        imgbtn7.setOnClickListener {
            val intent = Intent(this, ejercicio007::class.java)
            startActivity(intent)
        }

        val imgbtn8: ImageButton = findViewById(R.id.inclinadobancapecho)

        imgbtn8.setOnClickListener {
            val intent = Intent(this, ejercicio008::class.java)
            startActivity(intent)
        }

        val imgbtn9: ImageButton = findViewById(R.id.aperturaspecho)

        imgbtn9.setOnClickListener {
            val intent = Intent(this, ejercicio009::class.java)
            startActivity(intent)
        }

        val imgbtn10: ImageButton = findViewById(R.id.fondospecho)

        imgbtn10.setOnClickListener {
            val intent = Intent(this, ejercicio010::class.java)
            startActivity(intent)
        }

        val imgbtn11: ImageButton = findViewById(R.id.crossoverpecho)

        imgbtn11.setOnClickListener {
            val intent = Intent(this, ejercicio011::class.java)
            startActivity(intent)
        }

        val imgbtn12: ImageButton = findViewById(R.id.flexiones)

        imgbtn12.setOnClickListener {
            val intent = Intent(this, ejercicio012::class.java)
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