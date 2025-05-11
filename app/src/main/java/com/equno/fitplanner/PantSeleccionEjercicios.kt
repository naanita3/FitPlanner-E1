package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.equno.fitplanner.databinding.ActivitySelEjerciciosBinding // Importar el binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantSeleccionEjercicios : AppCompatActivity() {

    private lateinit var binding: ActivitySelEjerciciosBinding // Declarar el binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EjercicioAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySelEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerViewEjercicios // Acceder a la vista usando binding
        recyclerView.layoutManager = LinearLayoutManager(this)


        obtenerEjercicios()

        binding.btnConfirmar.setOnClickListener {
            val ejerciciosSeleccionados = adapter.getEjerciciosSeleccionados()
            if (ejerciciosSeleccionados.isNotEmpty()) {
                if (ejerciciosSeleccionados.size <= 7) {
                    val intent = Intent(this, PantallaConfirmacion::class.java)
                    intent.putParcelableArrayListExtra("ejerciciosSeleccionados", ArrayList(ejerciciosSeleccionados))
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Solo puedes seleccionar hasta 7 ejercicios", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Selecciona al menos un ejercicio", Toast.LENGTH_SHORT).show()
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

    private fun obtenerEjercicios() {
        db.collection("ejercicios")
            .get()
            .addOnSuccessListener { result ->
                val ejercicios = result.map { document ->
                    val data = document.data
                    Ejercicio(
                        id = document.id,
                        nombre = data["ejercicio"] as String,
                        tipo = data["tipo"] as String
                    )
                }
                adapter = EjercicioAdapter(ejercicios) { ejercicio, isChecked ->
                }
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error al cargar los ejercicios", Toast.LENGTH_SHORT).show()
            }
    }
}