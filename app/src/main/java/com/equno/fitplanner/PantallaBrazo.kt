package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PantallaBrazo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_brazo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var imgbtn: ImageButton= findViewById(R.id.entrenamientotriceps)

        imgbtn.setOnClickListener {
            val intent = Intent(this, PantallaTriceps::class.java)
            startActivity(intent)
        }
        var imgbtn2: ImageButton= findViewById(R.id.entrenamientobicep)

        imgbtn2.setOnClickListener {
            val intent = Intent(this, PantallaBiceps::class.java)
            startActivity(intent)
        }
        var imgbtn3: ImageButton= findViewById(R.id.entrenamientohombro)

        imgbtn3.setOnClickListener {
            val intent = Intent(this, PantallaHombro::class.java)
            startActivity(intent)
        }

    }
}