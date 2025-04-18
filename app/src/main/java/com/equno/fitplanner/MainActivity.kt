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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn: Button = findViewById(R.id.buttonLogin)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, pantalla2:: class.java)
            startActivity(intent)
        }

        val btnr: Button = findViewById(R.id.botonregistrate)
        btnr.setOnClickListener {

            val intent: Intent = Intent(this, crearcuenta:: class.java)
            startActivity(intent)
        }



    }
}