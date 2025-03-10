package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.ESPALDA.ejercicio001
import com.equno.fitplanner.ESPALDA.ejercicio002
import com.equno.fitplanner.ESPALDA.ejercicio003
import com.equno.fitplanner.ESPALDA.ejercicio004
import com.equno.fitplanner.ESPALDA.ejercicio005
import com.equno.fitplanner.ESPALDA.ejercicio006
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaEspalda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_espalda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgbtn: ImageButton = findViewById(R.id.jalonpechopolea)

        imgbtn.setOnClickListener {
            val intent = Intent(this, ejercicio001::class.java)
            startActivity(intent)

        }

        val imgbtn2: ImageButton = findViewById(R.id.remoconbarra)

        imgbtn2.setOnClickListener {
            val intent = Intent(this, ejercicio002::class.java)
            startActivity(intent)

        }

        val imgbtn3: ImageButton = findViewById(R.id.remomancuerna)

        imgbtn3.setOnClickListener {
            val intent = Intent(this, ejercicio003::class.java)
            startActivity(intent)

        }

        val imgbtn4: ImageButton = findViewById(R.id.pullover)

        imgbtn4.setOnClickListener {
            val intent = Intent(this, ejercicio004::class.java)
            startActivity(intent)

        }

        val imgbtn5: ImageButton = findViewById(R.id.pullups)

        imgbtn5.setOnClickListener {
            val intent = Intent(this, ejercicio005::class.java)
            startActivity(intent)

        }

        val imgbtn6: ImageButton = findViewById(R.id.remogironda)

        imgbtn6.setOnClickListener {
            val intent = Intent(this, ejercicio006::class.java)
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