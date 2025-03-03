package com.equno.fitplanner

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ActivitySetEjercicios : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EjercicioAdapter
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_ejercicios)

        recyclerView = findViewById(R.id.recyclerEjercicios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        firestore = FirebaseFirestore.getInstance()

        // Obtener ejercicios desde Firestore
        firestore.collection("ejercicios")
            .get()
            .addOnSuccessListener { result ->
                val ejercicios = ArrayList<Ejercicio>()
                for (document in result) {
                    val nombre = document.getString("ejercicios") ?: ""
                    val tipo = document.getString("tipo") ?: ""
                    ejercicios.add(Ejercicio(nombre, tipo))
                }
                adapter = EjercicioAdapter(ejercicios)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                // Manejar el error
            }

    }

}