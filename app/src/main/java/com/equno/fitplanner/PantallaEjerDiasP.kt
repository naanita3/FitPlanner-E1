package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PantallaEjerDiasP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dias_ejer_p)

        //*********BOTON DIA 1 PRINCIPIANTE**********************************************************
        val btnDia1p = findViewById<Button>(R.id.button)

        btnDia1p.setOnClickListener {
            val intent = Intent(this, PantallaDia1p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 2 PRINCIPIANTE**********************************************************
        val btnDia2p = findViewById<Button>(R.id.button2)

        btnDia2p.setOnClickListener {
            val intent = Intent(this, PantallaDia2p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 3 PRINCIPIANTE**********************************************************
        val btnDia3p = findViewById<Button>(R.id.button3)

        btnDia3p.setOnClickListener {
            val intent = Intent(this, PantallaDia3p::class.java)
            startActivity(intent)
        }

        //*********BOTON DIA 4 PRINCIPIANTE**********************************************************
        val btnDia4p = findViewById<Button>(R.id.button5)

        btnDia4p.setOnClickListener {
            val intent = Intent(this, PantallaDia4p::class.java)
            startActivity(intent)
        }
    }
}