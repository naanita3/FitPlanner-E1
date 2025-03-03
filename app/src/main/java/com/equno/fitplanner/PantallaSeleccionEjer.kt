package com.equno.fitplanner

//LIBRERIAS PARA LA PRIMER PARTE*************************************
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//LIBRERIAS PARA LA SEGUNDA PARTE*************************************
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


data class Ejercicio(
    val nombre: String,
    val tipo: String
)

//PRIMER PARTE*******************************************************
class EjercicioAdapter(private val ejercicios: List<Ejercicio>) : RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder>() {

    class EjercicioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreEjercicio: TextView = itemView.findViewById(R.id.tvNombreEjercicio)
        val tvTipoEjercicio: TextView = itemView.findViewById(R.id.tvTipoEjercicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjercicioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dis_ejercicios, parent, false)
        return EjercicioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EjercicioViewHolder, position: Int) {
        val ejercicio = ejercicios[position]
        holder.tvNombreEjercicio.text = ejercicio.nombre
        holder.tvTipoEjercicio.text = ejercicio.tipo
    }

    override fun getItemCount(): Int {
        return ejercicios.size
    }
}

//SEGUNDA PARTE*******************************************************
class EjerciciosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EjercicioAdapter
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sel_ejercicios)

        recyclerView = findViewById(R.id.recyclerEjercicios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        firestore = FirebaseFirestore.getInstance()

        // Obtener ejercicios desde Firestore
        firestore.collection("ejercicios")
            .get()
            .addOnSuccessListener { result ->
                val ejercicios = ArrayList<Ejercicio>()
                for (document in result) {
                    val nombre = document.getString("ejercicios") ?: ""
                    val tipo = document.getString("tipo") ?: ""
                    ejercicios.add(Ejercicio(nombre, tipo))
                }
                adapter = EjercicioAdapter(ejercicios)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { exception ->
                // Manejar el error
            }
    }
}

//class PantallaSeleccionEjer : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sel_ejercicios)

        // Referencia al botón
//        val btnMiRutina = findViewById<Button>(R.id.PantallaMiRutina)

        // Configurar el clic del botón
//        btnMiRutina.setOnClickListener {
//            // Crear un Intent para navegar a SelEjerciciosActivity
//            val intent = Intent(this, ActivitySetEjercicios::class.java)
//            startActivity(intent)
//        }
//    }
//}




