package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.equno.fitplanner.BICEPS.ejercicio019
import com.equno.fitplanner.BICEPS.ejercicio020
import com.equno.fitplanner.BICEPS.ejercicio021
import com.equno.fitplanner.BICEPS.ejercicio022
import com.equno.fitplanner.BICEPS.ejercicio023
import com.equno.fitplanner.BICEPS.ejercicio024
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaTriceps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_triceps)
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
                // Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }


        val imgbtn25: ImageButton = findViewById(R.id.)

        imgbtn25.setOnClickListener {
            val intent = Intent(this, ejercicio020::class.java)
            startActivity(intent)

        }

        val imgbtn26: ImageButton = findViewById(R.id.bicepsbayesian)

        imgbtn26.setOnClickListener {
            val intent = Intent(this, ejercicio021::class.java)
            startActivity(intent)

        }

        val imgbtn27: ImageButton = findViewById(R.id.bicepspredicador)

        imgbtn27.setOnClickListener {
            val intent = Intent(this, ejercicio022::class.java)
            startActivity(intent)

        }

        val imgbtn28: ImageButton = findViewById(R.id.bicepspredmartillo)

        imgbtn28.setOnClickListener {
            val intent = Intent(this, ejercicio023::class.java)
            startActivity(intent)

        }

        val imgbtn29: ImageButton = findViewById(R.id.bicepsbarra)

        imgbtn29.setOnClickListener {
            val intent = Intent(this, ejercicio024::class.java)
            startActivity(intent)

        }
        val imgbtn30: ImageButton = findViewById(R.id.bicepsmancsupino)

        imgbtn30.setOnClickListener {
            val intent = Intent(this, ejercicio019::class.java)
            startActivity(intent)

        }
    }
}