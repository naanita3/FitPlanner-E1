package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class crearcuenta : AppCompatActivity() {
    val db = Firebase.firestore;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crearcuenta)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn: Button = findViewById(R.id.buttonCCBueno)

        val inputNombre = findViewById<EditText>(R.id.crearCuentaNombre);
        val inputApellido = findViewById<EditText>(R.id.crearCuentaApellido);
        val inputCorreo = findViewById<EditText>(R.id.crearCuentaCorreo);
        val inputContrasena = findViewById<EditText>(R.id.crearCuentaContrasena);

        btn.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val apellido = inputApellido.text.toString()
            val correo = inputCorreo.text.toString()
            val password = inputContrasena.text.toString()

            val nombreEntero = "$nombre $apellido";

            val usuario = hashMapOf(
                "usuario" to nombreEntero,
                "correo" to correo,
                "password" to password
            )

            db
                .collection("usuarios")
                .add(usuario)

        }
    }
}