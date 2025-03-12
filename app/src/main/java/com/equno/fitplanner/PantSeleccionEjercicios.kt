package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.equno.fitplanner.databinding.ActivitySelEjerciciosBinding // Importar el binding

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