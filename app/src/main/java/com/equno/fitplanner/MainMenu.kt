package com.equno.fitplanner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainMenu : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        userId = intent.getStringExtra("user_id") ?: sharedPref.getString("user_id", null)

        if (userId == null) {
            Toast.makeText(this, "Sesión no válida", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupButtons()
        setupBottomNavigation()
    }


    private fun setupButtons() {
        //ejercicios
        findViewById<ImageButton>(R.id.entrenamientosP).setOnClickListener {
            startActivity(Intent(this, ExplorarEjercicios::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        findViewById<ImageButton>(R.id.consejos).setOnClickListener {
            startActivity(Intent(this, PantallaConsejos::class.java).apply {
                putExtra("user_id", userId)
            })
        }


        //rutinas predefinidas
        findViewById<ImageButton>(R.id.RutinasPredeterminadas).setOnClickListener {
            startActivity(Intent(this, PantallaSelNivel::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        //alimentos populares
        findViewById<ImageButton>(R.id.alimentosP).setOnClickListener {
            startActivity(Intent(this, ExplorarAlimentos::class.java).apply {
                putExtra("user_id", userId)

            })
        }

    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_explore -> {
                    startActivity(Intent(this, ExplorarEjercicios::class.java).apply {
                        putExtra("user_id", userId)
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                R.id.navigation_plan -> {
                    startActivity(Intent(this, ExplorarAlimentos::class.java).apply {
                        putExtra("user_id", userId)
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                R.id.navigation_account -> {
                    startActivity(Intent(this, PantallaMiCuenta::class.java).apply {
                        putExtra("user_id", userId)
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                R.id.navigation_routine -> {
                    startActivity(Intent(this, PantallaSelNivel::class.java).apply {
                        putExtra("user_id", userId)
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).selectedItemId = R.id.navigation_home
    }
}