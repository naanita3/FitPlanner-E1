package com.equno.fitplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PantallaConfirmacionAlimentos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlimentoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_confirmacion_alimentos)

        // Obtener los ejercicios seleccionados
        val alimentosSeleccionados = intent.getParcelableArrayListExtra<Alimento>("alimentosSeleccionados")

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewConfirmacionAlim)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mostrar los ejercicios seleccionados
        if (alimentosSeleccionados != null) {
            adapter = AlimentoAdapter(alimentosSeleccionados) { alimento, isChecked ->
                // No necesitas manejar selecciones aquí
            }
            recyclerView.adapter = adapter
        }
    }
}
