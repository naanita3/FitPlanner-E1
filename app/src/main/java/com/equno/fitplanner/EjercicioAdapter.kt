package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EjercicioAdapter(
    private val ejercicios: List<Ejercicio>,
    private val onEjercicioSeleccionado: (Ejercicio, Boolean) -> Unit
) : RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder>() {

    private val ejerciciosSeleccionados = mutableListOf<Ejercicio>()
    private var maxSeleccionados = 7 // límite

    inner class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreEjercicio)
        private val cbSeleccionar: CheckBox = itemView.findViewById(R.id.cbSeleccionar)

        fun bind(ejercicio: Ejercicio) {
            tvNombre.text = ejercicio.nombre

            cbSeleccionar.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (ejerciciosSeleccionados.size < maxSeleccionados) {
                        ejerciciosSeleccionados.add(ejercicio)
                    } else {
                        cbSeleccionar.isChecked = false
                        Toast.makeText(itemView.context, "Solo puedes seleccionar hasta 7 ejercicios", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    ejerciciosSeleccionados.remove(ejercicio)
                }
                onEjercicioSeleccionado(ejercicio, isChecked)
            }
        }
    }

    fun getEjerciciosSeleccionados(): List<Ejercicio> {
        return ejerciciosSeleccionados
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ejercicio, parent, false)
        return EjercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        holder.bind(ejercicios[position])
    }

    override fun getItemCount(): Int = ejercicios.size
}