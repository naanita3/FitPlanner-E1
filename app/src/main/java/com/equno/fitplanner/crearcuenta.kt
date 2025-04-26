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
import com.google.firebase.Timestamp
import com.google.firebase.firestore.firestore

class crearcuenta : AppCompatActivity() {
    private val db = Firebase.firestore
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crearcuenta)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)

        val btnRegistrar = findViewById<Button>(R.id.buttonCCBueno)
        val inputNombre = findViewById<EditText>(R.id.crearCuentaNombre)
        val inputApellido = findViewById<EditText>(R.id.crearCuentaApellido)
        val inputCorreo = findViewById<EditText>(R.id.crearCuentaCorreo)
        val inputContrasena = findViewById<EditText>(R.id.crearCuentaContrasena)

        btnRegistrar.setOnClickListener {
            val nombre = inputNombre.text.toString().trim()
            val apellido = inputApellido.text.toString().trim()
            val correo = inputCorreo.text.toString().trim()
            val password = inputContrasena.text.toString().trim()

            if (validarCampos(nombre, apellido, correo, password)) {
                registrarUsuario(nombre, apellido, correo, password)
            }
        }
    }

    private fun validarCampos(nombre: String, apellido: String, correo: String, password: String): Boolean {
        return when {
            nombre.isEmpty() -> {
                Toast.makeText(this, "Ingresa tu nombre", Toast.LENGTH_SHORT).show()
                false
            }
            apellido.isEmpty() -> {
                Toast.makeText(this, "Ingresa tu apellido", Toast.LENGTH_SHORT).show()
                false
            }
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

    private fun registrarUsuario(nombre: String, apellido: String, correo: String, password: String) {
        val nombreCompleto = "$nombre $apellido"

        // Creación d campos
        val usuario = hashMapOf(
            "nombre" to nombreCompleto,
            "correo" to correo,
            "password" to password,
            "peso" to 0.0,
            "altura" to 0.0,
            "imc" to 0.0,
            "fechaRegistro" to Timestamp.now(),
            "historialIMC" to emptyList<Map<String, Any>>()
        )

        db.collection("usuarios")
            .add(usuario)
            .addOnSuccessListener { documentReference ->
                // gardar el ID en SP
                val userId = documentReference.id
                sharedPref.edit()
                    .putString("user_id", userId)
                    .apply()

                // redireccionar a MainMenu y pasar el user_id
                val intent = Intent(this, MainMenu::class.java).apply {
                    putExtra("user_id", userId)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
                finish()

                Toast.makeText(this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al registrar: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}