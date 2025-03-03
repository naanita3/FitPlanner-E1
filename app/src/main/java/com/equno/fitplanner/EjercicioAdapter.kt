package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EjercicioAdapter(private val ejercicios: List<Ejercicio>) : RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder>() {

    // ViewHolder: Representa cada ítem de la lista
    class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreEjercicio: TextView = itemView.findViewById(R.id.tvNombreEjercicio)
        val tvTipoEjercicio: TextView = itemView.findViewById(R.id.tvTipoEjercicio)
    }

    // Crear nuevas vistas (ítems)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dis_ejercicios, parent, false)
        return EjercicioViewHolder(view)
    }

    // Asignar datos a las vistas
    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        val ejercicio = ejercicios[position]
        holder.tvNombreEjercicio.text = ejercicio.nombre
        holder.tvTipoEjercicio.text = ejercicio.tipo
    }

    // Número total de ítems en la lista
    override fun getItemCount(): Int {
        return ejercicios.size
    }
}