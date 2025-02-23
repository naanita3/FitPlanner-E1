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

class pantalla2 : AppCompatActivity() {
    val db = Firebase.firestore;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn: Button = findViewById(R.id.buttonRegistrar)

        val loginBtn: Button = findViewById(R.id.buttonIniciar2)

        val inputCorreo = findViewById<EditText>(R.id.loginCorreo);
        val inputPassword = findViewById<EditText>(R.id.loginPassword);

        btn.setOnClickListener {

        val intent: Intent = Intent(this, crearcuenta:: class.java)
        startActivity(intent)
    }

        loginBtn.setOnClickListener {
            val correo = inputCorreo.text.toString()
            val password = inputPassword.text.toString()

            db.collection("usuarios")
                .whereEqualTo("correo", correo)
                .whereEqualTo("password", password)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        println(document.data)
                    }
                }
        }

    }
}