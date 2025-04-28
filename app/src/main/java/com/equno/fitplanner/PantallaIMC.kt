package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class PantallaIMC : AppCompatActivity() {

    private val db = Firebase.firestore
    private lateinit var userId: String

    // Views
    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var cardResultado: CardView
    private lateinit var tvResultado: TextView
    private lateinit var tvClasificacion: TextView
    private lateinit var btnRecomendaciones: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcu_imc)

        // Obtener userId del Intent o SharedPreferences
        userId = intent.getStringExtra("user_id") ?: run {
            Toast.makeText(this, "Error: No se encontró usuario", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        //ver recomendaciones
        findViewById<Button>(R.id.btnRecomendaciones).setOnClickListener {
            startActivity(Intent(this, PantallaRecomIMC::class.java).apply {
                putExtra("user_id", userId)
            })
        }

        initViews()
        setupButtons()
    }

    private fun initViews() {
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        tvClasificacion = findViewById(R.id.tvClasificacion)
        cardResultado = findViewById(R.id.cardResultado)
        btnRecomendaciones = findViewById(R.id.btnRecomendaciones)
    }

    private fun setupButtons() {
        btnCalcular.setOnClickListener {
            calcularIMC()
        }

        /*btnRecomendaciones.setOnClickListener {
            mostrarRecomendaciones()
        }*/


    }

    private fun calcularIMC() {
        val pesoStr = etPeso.text.toString()
        val alturaStr = etAltura.text.toString()

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese peso y altura", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val peso = pesoStr.toDouble()
            val altura = alturaStr.toDouble() / 100 // Convertir cm a m

            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Los valores deben ser mayores a cero", Toast.LENGTH_SHORT).show()
                return
            }

            val imc = peso / (altura * altura)
            mostrarResultadoIMC(imc)
            guardarEnFirestore(peso, alturaStr.toDouble(), imc)

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarResultadoIMC(imc: Double) {
        // Mostrar el cardview con los resultados
        cardResultado.visibility = View.VISIBLE
        btnRecomendaciones.visibility = View.VISIBLE

        // Formatear el IMC a 2 decimales
        val imcFormateado = String.format("%.2f", imc)
        tvResultado.text = "Tu IMC: $imcFormateado"

        // Determinar clasificación
        val (clasificacion, color) = when {
            imc < 18.5 -> Pair("Bajo peso", "#FFA000") // Amarillo/naranja
            imc < 25 -> Pair("Peso normal", "#4CAF50") // Verde
            imc < 30 -> Pair("Sobrepeso", "#FF9800") // Naranja
            imc < 35 -> Pair("Obesidad grado I", "#F44336") // Rojo
            imc < 40 -> Pair("Obesidad grado II", "#D32F2F") // Rojo oscuro
            else -> Pair("Obesidad grado III", "#B71C1C") // Rojo muy oscuro
        }

        tvClasificacion.text = clasificacion
        tvClasificacion.setTextColor(android.graphics.Color.parseColor(color))
    }

    private fun guardarEnFirestore(peso: Double, altura: Double, imc: Double) {
        val registroIMC = hashMapOf(
            "fecha" to Timestamp.now(),
            "valor" to imc,
            "peso" to peso,
            "altura" to altura
        )

        db.collection("usuarios").document(userId)
            .update(
                "peso", peso,
                "altura", altura,
                "imc", imc,
                "historialIMC", FieldValue.arrayUnion(registroIMC)
            )
            .addOnSuccessListener {
                Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    /*private fun mostrarRecomendaciones() {
        val imcText = tvResultado.text.toString().replace("Tu IMC: ", "").toDoubleOrNull() ?: return
        val clasificacion = tvClasificacion.text.toString()

        val categoria = when {
            imcText < 18.5 -> "bajo_peso"
            imcText < 25 -> "normal"
            imcText < 30 -> "sobrepeso"
            else -> "obesidad"
        }

        db.collection("recetas")
            .whereEqualTo("categoriaIMC", categoria)
            .limit(3)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    val recetas = documents.toObjects(Receta::class.java)
                    mostrarListaRecetas(recetas, clasificacion)
                } else {
                    Toast.makeText(this, "Pronto", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al obtener recomendaciones: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun mostrarListaRecetas(recetas: List<Receta>, clasificacion: String) {
        val recetaTitles = recetas.map { it.nombre }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Recomendaciones para $clasificacion")
            .setItems(recetaTitles) { dialog, which ->
                mostrarDetalleReceta(recetas[which])
            }
            .setPositiveButton("Cerrar", null)
            .show()
    }

    private fun mostrarDetalleReceta(receta: Receta) {
        AlertDialog.Builder(this)
            .setTitle(receta.nombre)
            .setMessage("""
                Ingredientes:
                ${receta.ingredientes.joinToString("\n• ", "• ")}

                Calorías: ${receta.calorias} kcal
            """.trimIndent())
            .setPositiveButton("OK", null)
            .show()
    }*/
}

/* Modelo de Receta (debe estar en otro archivo Receta.kt)
data class Receta(
    val nombre: String = "",
    val ingredientes: List<String> = emptyList(),
    val calorias: Int = 0,
    val categoriaIMC: String = ""
)*/