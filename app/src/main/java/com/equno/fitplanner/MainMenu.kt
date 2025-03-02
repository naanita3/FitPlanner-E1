package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        val imgbtn : ImageButton = findViewById(R.id.entrenamientosP)

        imgbtn.setOnClickListener {
            val intent = Intent(this, ExplorarEjercicios::class.java)
            startActivity(intent)
        }
    }


}

