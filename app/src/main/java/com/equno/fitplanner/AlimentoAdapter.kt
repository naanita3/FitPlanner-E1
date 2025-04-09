package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AlimentoAdapter(
    private val alimentos: List<Alimento>, // Lista de alimento
    private val onAlimentoSeleccionado: (Alimento, Boolean) -> Unit // Callback para manejar la selección
) : RecyclerView.Adapter<AlimentoAdapter.AlimentoViewHolder>() {

    private val alimentosSeleccionados = mutableListOf<Alimento>() // Lista de alimento seleccionados
    private var maxSeleccionados = 7 // Límite de alimento seleccionados

    // ViewHolder para cada item del RecyclerView
    inner class AlimentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreAlimento) // TextView para el nombre
        private val cbSeleccionar: CheckBox = itemView.findViewById(R.id.cbSeleccionar) // CheckBox para seleccionar

        // Método para vincular los datos a las vistas
        fun bind(alimento: Alimento) {
            tvNombre.text = alimento.nombre // Asignar el nombre del alimento al TextView

            // Listener para manejar la selección del alimento
            cbSeleccionar.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Si el alimento está seleccionado y no se ha alcanzado el límite
                    if (alimentosSeleccionados.size < maxSeleccionados) {
                        alimentosSeleccionados.add(alimento) // Agregar el alimento a la lista de seleccionados
                    } else {
                        cbSeleccionar.isChecked = false // Desmarcar el CheckBox si se supera el límite
                        Toast.makeText(itemView.context, "Solo puedes seleccionar hasta 7 alimentos", Toast.LENGTH_SHORT).show() // Mostrar mensaje de error
                    }
                } else {
                    // Si el alimento se deselecciona
                    alimentosSeleccionados.remove(alimento) // Eliminar el alimento de la lista de seleccionados
                }
                onAlimentoSeleccionado(alimento, isChecked) // Llamar al callback para notificar la selección
            }
        }
    }

    // Método para obtener la lista de alimentos seleccionados
    fun getAlimentosSeleccionados(): List<Alimento> {
        return alimentosSeleccionados
    }

    // Método para crear un ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
        // Inflar el layout de cada item (item_alimento.xml)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alimento, parent, false)
        return AlimentoViewHolder(view) // Devolver un nuevo ViewHolder
    }

    // Método para vincular los datos a un ViewHolder en una posición específica
    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
        holder.bind(alimentos[position]) // Vincular los datos del alimentos en la posición actual
    }

    // Método para obtener el número total de items en la lista
    override fun getItemCount(): Int = alimentos.size
}