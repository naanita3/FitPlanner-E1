package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.equno.fitplanner.databinding.ActivitySelAlimentosBinding

class PantSeleccionAlimentos : AppCompatActivity() {

    private lateinit var binding: ActivitySelAlimentosBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlimentoAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelAlimentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView
        recyclerView = binding.recyclerViewAlimentos
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        // Cargar alimentos desde Firestore
        obtenerAlimentos()

        // Configurar botón de confirmación
        binding.btnConfirmarAlim.setOnClickListener {
            val alimentosSeleccionados = adapter.getAlimentosSeleccionados()
            when {
                alimentosSeleccionados.isEmpty() -> {
                    Toast.makeText(this, "Selecciona al menos un alimento", Toast.LENGTH_SHORT).show()
                }
                alimentosSeleccionados.size > 7 -> {
                    Toast.makeText(this, "Máximo 7 alimentos permitidos", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val intent = Intent(this, PantallaConfirmacionAlimentos::class.java).apply {
                        putParcelableArrayListExtra("alimentosSeleccionados", ArrayList(alimentosSeleccionados))
                    }
                    startActivity(intent)
                }
            }
        }
    }

    private fun obtenerAlimentos() {
        db.collection("alimentos")
            .get()
            .addOnSuccessListener { result ->
                val alimentos = result.mapNotNull { document ->
                    try {
                        Alimento(
                            id = document.id,
                            nombre = document.getString("alimento") ?: "",
                            tipo = document.getString("tipo") ?: "",
                            imagenUrl = document.getString("imagenUrl") ?: ""
                        ).also {
                            Log.d("Firestore", "Alimento cargado: ${it.nombre} - URL: ${it.imagenUrl}")
                        }
                    } catch (e: Exception) {
                        Log.e("Firestore", "Error al parsear documento ${document.id}", e)
                        null
                    }
                }

                adapter = AlimentoAdapter(alimentos) { alimento, isChecked ->
                    // Callback opcional para manejar selecciones individuales
                }
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error al cargar alimentos", Toast.LENGTH_SHORT).show()
                Log.e("Firestore", "Error al obtener alimentos", exception)
            }
    }
}