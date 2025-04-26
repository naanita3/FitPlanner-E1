package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcu_imc)

        val etPeso      = findViewById<EditText>(R.id.editTextPeso)
        val etEstatura  = findViewById<EditText>(R.id.editTextEstatura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.editTextResultado)

        btnCalcular.setOnClickListener {
            val pesoKg      = etPeso.text.toString().toFloatOrNull()
            val estCm       = etEstatura.text.toString().toFloatOrNull()

            if (pesoKg != null && estCm != null && estCm > 0) {
                // Convertir estatura de cm a metros
                val estMetros = estCm / 100f

                // Calcular IMC
                val imc = (estMetros * estMetros) / pesoKg

                // Categoría y recomendación
                val categoriaYRecomendacion = when {
                    imc < 18.5 ->
                        "Bajo peso\nRecomendación: Aumenta tu ingesta calórica con alimentos nutritivos y consulta a un especialista."
                    imc in 18.5..24.9 ->
                        "Peso normal\nRecomendación: Mantén una alimentación equilibrada y sigue activo."
                    imc in 25f..29.9f ->
                        "Sobrepeso\nRecomendación: Considera mejorar tu dieta y aumentar tu actividad física."
                    imc in 30f..34.9f ->
                        "Obesidad grado I\nRecomendación: Es importante consultar a un profesional de salud para ajustar tus hábitos."
                    imc in 35f..39.9f ->
                        "Obesidad grado II\nRecomendación: Necesitas atención médica para prevenir riesgos mayores."
                    else ->
                        "Obesidad grado III (mórbida)\nRecomendación: Busca ayuda médica urgente para mejorar tu calidad de vida."
                }

                // Mostrar resultado en TextView
                tvResultado.text = "Tu IMC es: %.2f\n\n$categoriaYRecomendacion".format(imc)
            } else {
                tvResultado.text = "Por favor, ingresa valores válidos."
            }
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
                }// Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }
    }
}
