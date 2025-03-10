package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaDia1m : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia1_m)

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