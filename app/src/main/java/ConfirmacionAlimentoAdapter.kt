package com.equno.fitplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ConfirmacionAlimentoAdapter(
    private val alimentos: List<Alimento>
) : RecyclerView.Adapter<ConfirmacionAlimentoAdapter.ConfirmacionViewHolder>() {

    inner class ConfirmacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreAlimento)
        private val tvTipo: TextView = itemView.findViewById(R.id.tvTipoAlimento)
        private val ivImagen: ImageView = itemView.findViewById(R.id.ivImagenAlimento)

        fun bind(alimento: Alimento) {
            tvNombre.text = alimento.nombre
            tvTipo.text = alimento.tipo.uppercase()

            // Carga de imagen con manejo de errores
            Glide.with(itemView.context)
                .load(alimento.imagenUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_exercise_placeholder)
                .error(R.drawable.ic_exercise_placeholder)
                .centerCrop()
                .into(ivImagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alimento, parent, false)
        return ConfirmacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConfirmacionViewHolder, position: Int) {
        holder.bind(alimentos[position])
    }

    override fun getItemCount(): Int = alimentos.size
}