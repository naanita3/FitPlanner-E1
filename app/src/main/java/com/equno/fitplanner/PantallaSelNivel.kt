package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PantallaSelNivel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_nivel)

        //*********BOTON DE PRINCIPIANTE**********************************************************
        val btnPrincipiante = findViewById<Button>(R.id.principiantebtn)

        btnPrincipiante.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasP::class.java)
            startActivity(intent)
        }


        //*********BOTON DE MEDIO**********************************************************
        val btnMedio = findViewById<Button>(R.id.mediobtn)

        btnMedio.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasM::class.java)
            startActivity(intent)
        }


        //*********BOTON DE AVANZADO**********************************************************
        val btnAvanzado = findViewById<Button>(R.id.avanzadobtn)

        btnAvanzado.setOnClickListener {
            val intent = Intent(this, PantallaEjerDiasA::class.java)
            startActivity(intent)
        }
    }
}

