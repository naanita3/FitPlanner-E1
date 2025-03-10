package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
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
                // Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }

    }

}