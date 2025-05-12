package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ConfirmacionEjercicioAdapter(
    private val ejercicios: List<Ejercicio>
) : RecyclerView.Adapter<ConfirmacionEjercicioAdapter.ConfirmacionViewHolder>() {

    inner class ConfirmacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreEjercicio)
        private val tvTipo: TextView = itemView.findViewById(R.id.tvTipoEjercicio)
        private val ivImagen: ImageView = itemView.findViewById(R.id.ivImagenEjercicio)

        fun bind(ejercicio: Ejercicio) {
            tvNombre.text = ejercicio.nombre
            tvTipo.text = ejercicio.tipo.uppercase()

            // Carga de imagen con manejo de errores mejorado
            Glide.with(itemView.context)
                .load(ejercicio.imagenUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_exercise_placeholder)
                .error(R.drawable.ic_exercise_placeholder)
                .centerCrop()
                .into(ivImagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_confirmacion_ejercicio, parent, false)
        return ConfirmacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConfirmacionViewHolder, position: Int) {
        holder.bind(ejercicios[position])
    }

    override fun getItemCount(): Int = ejercicios.size
}