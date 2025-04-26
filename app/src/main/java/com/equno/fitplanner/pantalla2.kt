package com.equno.fitplanner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class pantalla2 : AppCompatActivity() {
    private val db = Firebase.firestore
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val btnRegistrar = findViewById<Button>(R.id.buttonRegistrar)
        val btnLogin = findViewById<Button>(R.id.buttonIniciar2)
        val inputCorreo = findViewById<EditText>(R.id.loginCorreo)
        val inputPassword = findViewById<EditText>(R.id.loginPassword)

        // Verificar si ya hay una sesión activa
        if (sharedPref.getString("user_id", null) != null) {
            redirigirAMainMenu(sharedPref.getString("user_id", null)!!)
        }

        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, crearcuenta::class.java))
        }

        btnLogin.setOnClickListener {
            val correo = inputCorreo.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (validarCredenciales(correo, password)) {
                autenticarUsuario(correo, password)
            }
        }
    }

    private fun validarCredenciales(correo: String, password: String): Boolean {
        return when {
            correo.isEmpty() || !correo.contains("@") -> {
                Toast.makeText(this, "Ingresa un correo válido", Toast.LENGTH_SHORT).show()
                false
            }
            password.length < 6 -> {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun autenticarUsuario(correo: String, password: String) {
        db.collection("usuarios")
            .whereEqualTo("correo", correo)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val userId = documents.documents[0].id
                    sharedPref.edit().putString("user_id", userId).apply()
                    redirigirAMainMenu(userId)
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error de conexión: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun redirigirAMainMenu(userId: String) {
        val intent = Intent(this, MainMenu::class.java).apply {
            putExtra("user_id", userId)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}