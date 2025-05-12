package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EjercicioAdapter(
    private val ejercicios: List<Ejercicio>,
    private val onItemChecked: (Ejercicio, Boolean) -> Unit
) : RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder>() {

    private val selectedItems = mutableSetOf<String>()
    private var lastCheckedPosition = -1

    inner class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreEjercicio)
        private val tvTipo: TextView = itemView.findViewById(R.id.tvTipoEjercicio)
        private val cbSeleccionar: CheckBox = itemView.findViewById(R.id.cbSeleccionar)
        private val ivImagen: ImageView = itemView.findViewById(R.id.ivImagenEjercicio)

        fun bind(ejercicio: Ejercicio) {
            tvNombre.text = ejercicio.nombre
            tvTipo.text = ejercicio.tipo.uppercase()
            cbSeleccionar.isChecked = selectedItems.contains(ejercicio.id)

            // Cargar imagen con Glide
            Glide.with(itemView.context)
                .load(ejercicio.imagenUrl)
                .placeholder(R.drawable.ic_exercise_placeholder)
                .error(R.drawable.ic_exercise_placeholder)
                .centerCrop()
                .into(ivImagen)

            // Manejar clic en el ítem completo
            itemView.setOnClickListener {
                cbSeleccionar.toggle()
                handleSelection(ejercicio, cbSeleccionar.isChecked)
            }

            // Manejar cambio en el CheckBox
            cbSeleccionar.setOnCheckedChangeListener { _, isChecked ->
                handleSelection(ejercicio, isChecked)
            }
        }

        private fun handleSelection(ejercicio: Ejercicio, isChecked: Boolean) {
            if (isChecked) {
                selectedItems.add(ejercicio.id)
            } else {
                selectedItems.remove(ejercicio.id)
            }
            onItemChecked(ejercicio, isChecked)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ejercicio, parent, false)
        return EjercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        holder.bind(ejercicios[position])
    }

    override fun getItemCount(): Int = ejercicios.size

    fun getEjerciciosSeleccionados(): List<Ejercicio> {
        return ejercicios.filter { selectedItems.contains(it.id) }
    }

    fun clearSelections() {
        selectedItems.clear()
        notifyDataSetChanged()
    }
}