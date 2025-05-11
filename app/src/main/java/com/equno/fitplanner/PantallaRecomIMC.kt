package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class PantallaRecomIMC : AppCompatActivity() {

    private val db = Firebase.firestore
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recom_imc)


        // Obtener userId del Intent o SharedPreferences
        userId = intent.getStringExtra("user_id") ?: run {
            Toast.makeText(this, "Error: No se encontró usuario", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //boton de bajo peso
        findViewById<Button>(R.id.btnBajoPeso).setOnClickListener {
            startActivity(Intent(this, PantallaBajoPeso::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        //boton de peso normal
        findViewById<Button>(R.id.btnPesoNormal).setOnClickListener {
            startActivity(Intent(this, PantallaPesoNormal::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        //boton de sobrepeso
        findViewById<Button>(R.id.btnSobrepeso).setOnClickListener {
            startActivity(Intent(this, PantallaSobrepeso::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        //boton de obesidad 1
        findViewById<Button>(R.id.btnObesidadUno).setOnClickListener {
            startActivity(Intent(this, PantallaObesidadUno::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        //boton de obesidad 2
        findViewById<Button>(R.id.btnObesidadDos).setOnClickListener {
            startActivity(Intent(this, PantallaObesidadDos::class.java).apply {
                putExtra("user_id", userId)
            })
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
                }

                R.id.navigation_routine -> {
                    if (this.javaClass != PantallaSelNivel::class.java) {
                        val intent = Intent(this, PantallaSelNivel::class.java)
                        startActivity(intent)
                    }
                    true
                }

                R.id.navigation_account -> {
                    if (this.javaClass != PantallaMiCuenta::class.java) {
                        val intent = Intent(this, PantallaMiCuenta::class.java)
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
