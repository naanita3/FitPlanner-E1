package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.equno.fitplanner.databinding.ActivitySelAlimentosBinding // Importar el binding

class PantSeleccionAlimentos : AppCompatActivity() {

    private lateinit var binding: ActivitySelAlimentosBinding // Declarar el binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlimentoAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySelAlimentosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerViewAlimentos // Acceder a la vista usando binding
        recyclerView.layoutManager = LinearLayoutManager(this)


        obtenerAlimentos()

        binding.btnConfirmarAlim.setOnClickListener {
            val alimentosSeleccionados = adapter.getAlimentosSeleccionados()
            if (alimentosSeleccionados.isNotEmpty()) {
                if (alimentosSeleccionados.size <= 7) {
                    val intent = Intent(this, PantallaConfirmacionAlimentos::class.java)
                    intent.putParcelableArrayListExtra("alimentosSeleccionados", ArrayList(alimentosSeleccionados))
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Solo puedes seleccionar hasta 7 alimentos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Selecciona al menos un alimento", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun obtenerAlimentos() {
        db.collection("alimentos")
            .get()
            .addOnSuccessListener { result ->
                val alimentos = result.map { document ->
                    val data = document.data
                    Alimento(
                        id = document.id,
                        nombre = data["alimento"] as String,
                        tipo = data["tipo"] as String
                    )
                }
                adapter = AlimentoAdapter(alimentos) { alimento, isChecked ->
                }
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error al cargar los alimentos", Toast.LENGTH_SHORT).show()
            }
    }
}