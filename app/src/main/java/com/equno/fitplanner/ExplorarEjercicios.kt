package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExplorarEjercicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explorar_ejercicios)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgbtn: ImageButton = findViewById(R.id.entrenamientopecho)

        imgbtn.setOnClickListener {
            val intent = Intent(this, PantallaPectoral::class.java)
            startActivity(intent)
        }

        val imgbtn2: ImageButton = findViewById(R.id.entrenamientoespalda)

        imgbtn2.setOnClickListener {
            val intent = Intent(this, PantallaEspalda::class.java)
            startActivity(intent)
        }
        val imgbtn3: ImageButton = findViewById(R.id.entrenamientobrazo)

        imgbtn3.setOnClickListener {
            val intent = Intent(this, PantallaBrazo::class.java)
            startActivity(intent)
        }
    }




}