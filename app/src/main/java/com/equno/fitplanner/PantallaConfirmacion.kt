package com.equno.fitplanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PantallaConfirmacion : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EjercicioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_confirmacion)

        // Obtener los ejercicios seleccionados
        val ejerciciosSeleccionados = intent.getParcelableArrayListExtra<Ejercicio>("ejerciciosSeleccionados")

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewConfirmacion)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mostrar los ejercicios seleccionados
        if (ejerciciosSeleccionados != null) {
            adapter = EjercicioAdapter(ejerciciosSeleccionados) { ejercicio, isChecked ->
                // No necesitas manejar selecciones aquí
            }
            recyclerView.adapter = adapter
        }
    }
}