package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1. Verificar si hay sesión activa al iniciar
        val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        if (sharedPref.getString("user_id", null) != null) {
            // Si hay usuario, redirigir al menú principal
            startActivity(Intent(this, MainMenu::class.java))
            finish() // Evita que el usuario vuelva atrás
        }

        // 2. Botón de login (existente)
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            startActivity(Intent(this, pantalla2::class.java))
        }

        // 3. Botón de registro (existente)
        findViewById<Button>(R.id.botonregistrate).setOnClickListener {
            startActivity(Intent(this, crearcuenta::class.java))
        }
    }
}