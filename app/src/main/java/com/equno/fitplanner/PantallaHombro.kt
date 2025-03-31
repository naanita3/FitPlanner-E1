package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.HOMBRO.ejercicio031
import com.equno.fitplanner.HOMBRO.ejercicio032
import com.equno.fitplanner.HOMBRO.ejercicio033
import com.equno.fitplanner.HOMBRO.ejercicio034
import com.equno.fitplanner.HOMBRO.ejercicio035
import com.equno.fitplanner.HOMBRO.ejercicio036
import com.equno.fitplanner.TRICEPS.ejercicio025
import com.equno.fitplanner.TRICEPS.ejercicio026
import com.equno.fitplanner.TRICEPS.ejercicio027
import com.equno.fitplanner.TRICEPS.ejercicio028
import com.equno.fitplanner.TRICEPS.ejercicio029
import com.equno.fitplanner.TRICEPS.ejercicio030
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaHombro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_hombro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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

        val imgbtn31: ImageButton = findViewById(R.id.hombropressmilitar)

        imgbtn31.setOnClickListener {
            val intent = Intent(this, ejercicio031::class.java)
            startActivity(intent)

        }

        val imgbtn32: ImageButton = findViewById(R.id.hombroelevacionlat)

        imgbtn32.setOnClickListener {
            val intent = Intent(this, ejercicio032::class.java)
            startActivity(intent)

        }

        val imgbtn33: ImageButton = findViewById(R.id.hombroelevacionfront)

        imgbtn33.setOnClickListener {
            val intent = Intent(this, ejercicio033::class.java)
            startActivity(intent)

        }

        val imgbtn34: ImageButton = findViewById(R.id.hombroelevacionpost)

        imgbtn34.setOnClickListener {
            val intent = Intent(this, ejercicio034::class.java)
            startActivity(intent)

        }

        val imgbtn35: ImageButton = findViewById(R.id.hombrojalonmenton)

        imgbtn35.setOnClickListener {
            val intent = Intent(this, ejercicio035::class.java)
            startActivity(intent)

        }
        val imgbtn36: ImageButton = findViewById(R.id.hombrolatpolea)

        imgbtn36.setOnClickListener {
            val intent = Intent(this, ejercicio036::class.java)
            startActivity(intent)

        }
    }
}