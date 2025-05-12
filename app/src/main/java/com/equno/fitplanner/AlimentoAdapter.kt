package com.equno.fitplanner

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class AlimentoAdapter(
    private val alimentos: List<Alimento>,
    private val onAlimentoSeleccionado: (Alimento, Boolean) -> Unit = { _, _ -> }
) : RecyclerView.Adapter<AlimentoAdapter.AlimentoViewHolder>() {

    private val alimentosSeleccionados = mutableSetOf<String>() // Guardamos IDs para mejor manejo
    private val maxSeleccionados = 7

    inner class AlimentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombreAlimento)
        private val tvTipo: TextView = itemView.findViewById(R.id.tvTipoAlimento)
        private val ivImagen: ImageView = itemView.findViewById(R.id.ivImagenAlimento)
        private val cbSeleccionar: CheckBox = itemView.findViewById(R.id.cbSeleccionar)

        fun bind(alimento: Alimento) {
            // Configurar textos
            tvNombre.text = alimento.nombre
            tvTipo.text = alimento.tipo.uppercase()

            // Cargar imagen con Glide
            cargarImagen(alimento.imagenUrl)

            // Configurar checkbox
            cbSeleccionar.isChecked = alimentosSeleccionados.contains(alimento.id)
            cbSeleccionar.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (alimentosSeleccionados.size < maxSeleccionados) {
                        alimentosSeleccionados.add(alimento.id)
                    } else {
                        cbSeleccionar.isChecked = false
                        showToast("Máximo $maxSeleccionados alimentos permitidos")
                    }
                } else {
                    alimentosSeleccionados.remove(alimento.id)
                }
                onAlimentoSeleccionado(alimento, isChecked)
            }

            // Manejar clic en el item completo
            itemView.setOnClickListener {
                cbSeleccionar.isChecked = !cbSeleccionar.isChecked
            }
        }

        private fun cargarImagen(url: String) {
            if (url.isBlank()) {
                ivImagen.setImageResource(R.drawable.ic_exercise_placeholder)
                return
            }

            Glide.with(itemView.context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_exercise_placeholder)
                .error(R.drawable.ic_exercise_placeholder)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e("Glide", "Error al cargar imagen: $url", e)
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .into(ivImagen)
        }

        private fun showToast(message: String) {
            Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alimento, parent, false)
        return AlimentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
        holder.bind(alimentos[position])
    }

    override fun getItemCount(): Int = alimentos.size

    fun getAlimentosSeleccionados(): List<Alimento> {
        return alimentos.filter { alimentosSeleccionados.contains(it.id) }
    }

    fun clearSelections() {
        alimentosSeleccionados.clear()
        notifyDataSetChanged()
    }
}