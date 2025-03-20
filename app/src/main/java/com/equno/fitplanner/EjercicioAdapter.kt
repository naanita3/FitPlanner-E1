package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EjercicioAdapter(
    private val ejercicios: List<Ejercicio>, // Lista de ejercicios
    private val onEjercicioSeleccionado: (Ejercicio, Boolean) -> Unit // Callback para manejar la selección
) : RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder>() {

    private val ejerciciosSeleccionados = mutableListOf<Ejercicio>() // Lista de ejercicios seleccionados
    private var maxSeleccionados = 7 // Límite de ejercicios seleccionados

    // ViewHolder para cada item del RecyclerView
    inner class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreEjercicio) // TextView para el nombre
        private val cbSeleccionar: CheckBox = itemView.findViewById(R.id.cbSeleccionar) // CheckBox para seleccionar

        // Método para vincular los datos a las vistas
        fun bind(ejercicio: Ejercicio) {
            tvNombre.text = ejercicio.nombre // Asignar el nombre del ejercicio al TextView

            // Listener para manejar la selección del ejercicio
            cbSeleccionar.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Si el ejercicio está seleccionado y no se ha alcanzado el límite
                    if (ejerciciosSeleccionados.size < maxSeleccionados) {
                        ejerciciosSeleccionados.add(ejercicio) // Agregar el ejercicio a la lista de seleccionados
                    } else {
                        cbSeleccionar.isChecked = false // Desmarcar el CheckBox si se supera el límite
                        Toast.makeText(itemView.context, "Solo puedes seleccionar hasta 7 ejercicios", Toast.LENGTH_SHORT).show() // Mostrar mensaje de error
                    }
                } else {
                    // Si el ejercicio se deselecciona
                    ejerciciosSeleccionados.remove(ejercicio) // Eliminar el ejercicio de la lista de seleccionados
                }
                onEjercicioSeleccionado(ejercicio, isChecked) // Llamar al callback para notificar la selección
            }
        }
    }

    // Método para obtener la lista de ejercicios seleccionados
    fun getEjerciciosSeleccionados(): List<Ejercicio> {
        return ejerciciosSeleccionados
    }

    // Método para crear un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        // Inflar el layout de cada item (item_ejercicio.xml)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ejercicio, parent, false)
        return EjercicioViewHolder(view) // Devolver un nuevo ViewHolder
    }

    // Método para vincular los datos a un ViewHolder en una posición específica
    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        holder.bind(ejercicios[position]) // Vincular los datos del ejercicio en la posición actual
    }

    // Método para obtener el número total de items en la lista
    override fun getItemCount(): Int = ejercicios.size
}