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
import com.equno.fitplanner.TRICEPS.ejercicio025
import com.equno.fitplanner.TRICEPS.ejercicio026
import com.equno.fitplanner.TRICEPS.ejercicio027
import com.equno.fitplanner.TRICEPS.ejercicio028
import com.equno.fitplanner.TRICEPS.ejercicio029
import com.equno.fitplanner.TRICEPS.ejercicio030
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
                R.id.navigation_plan -> {
                    if (this.javaClass != ExplorarAlimentos::class.java) {
                        val intent = Intent(this, ExplorarAlimentos::class.java)
                        startActivity(intent)
                    }
                    true
                }
                else -> false
            }
        }


        val imgbtn25: ImageButton = findViewById(R.id.tricepsjms)

        imgbtn25.setOnClickListener {
            val intent = Intent(this, ejercicio025::class.java)
            startActivity(intent)

        }

        val imgbtn26: ImageButton = findViewById(R.id.tricepspoleaal)

        imgbtn26.setOnClickListener {
            val intent = Intent(this, ejercicio026::class.java)
            startActivity(intent)

        }

        val imgbtn27: ImageButton = findViewById(R.id.tricepscop)

        imgbtn27.setOnClickListener {
            val intent = Intent(this, ejercicio027::class.java)
            startActivity(intent)

        }

        val imgbtn28: ImageButton = findViewById(R.id.tricepsskul)

        imgbtn28.setOnClickListener {
            val intent = Intent(this, ejercicio028::class.java)
            startActivity(intent)

        }

        val imgbtn29: ImageButton = findViewById(R.id.tricepsdip)

        imgbtn29.setOnClickListener {
            val intent = Intent(this, ejercicio029::class.java)
            startActivity(intent)

        }
        val imgbtn30: ImageButton = findViewById(R.id.tricepspoleabaa)

        imgbtn30.setOnClickListener {
            val intent = Intent(this, ejercicio030::class.java)
            startActivity(intent)

        }
    }
}