package com.equno.fitplanner

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.equno.fitplanner.databinding.ActivityPantallaMiCuentaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class PantallaMiCuenta : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaMiCuentaBinding
    private val db = Firebase.firestore
    private lateinit var userId: String
    private val avatares = listOf(
        R.drawable.avatar1,
        R.drawable.avatar2,
        R.drawable.avatar3,
        R.drawable.avatar4
    )
    private var avatarSeleccionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaMiCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userId = intent.getStringExtra("user_id") ?: run {
            Toast.makeText(this, "Error: No se encontró usuario", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        cargarDatosUsuario()
        setupButtons()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (this.javaClass != MainMenu::class.java) {
                        val intent = Intent(this, MainMenu::class.java)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_explore -> {
                    if (this.javaClass != ExplorarEjercicios::class.java) {
                        val intent = Intent(this, ExplorarEjercicios::class.java)
                        startActivity(intent)
                    }
                    true
                }
                R.id.navigation_plan -> {
                    if (this.javaClass != ExplorarAlimentos::class.java) {
                        val intent = Intent(this, ExplorarAlimentos::class.java)
                        startActivity(intent)
                    }
                    true
                }

                R.id.navigation_routine -> {
                    if (this.javaClass != PantallaSelNivel::class.java) {
                        val intent = Intent(this, PantallaSelNivel::class.java)
                        startActivity(intent)
                    }
                    true
                }

                R.id.navigation_account -> {
                    if (this.javaClass != PantallaMiCuenta::class.java) {
                        val intent = Intent(this, PantallaMiCuenta::class.java)
                        startActivity(intent)
                    }
                    true
                }
                // Agrega los otros casos de navegación aquí si es necesario
                else -> false
            }
        }
    }

    private fun cargarDatosUsuario() {
        db.collection("usuarios").document(userId).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    // Datos básicos del usuario
                    binding.tvNombreUsuario.text = document.getString("nombre") ?: "Usuario"
                    binding.tvEmailUsuario.text = document.getString("correo") ?: "usuario@mail.com"

                    // Avatar (si no existe, usar el primero por defecto)
                    avatarSeleccionado = (document.getLong("avatar") ?: 0).toInt()
                    if (avatarSeleccionado in avatares.indices) {
                        binding.imageView2.setImageResource(avatares[avatarSeleccionado])
                    } else {
                        binding.imageView2.setImageResource(avatares[0])
                    }

                    // Datos de IMC
                    val imc = document.getDouble("imc") ?: 0.0
                    val historialIMC = document.get("historialIMC") as? List<Map<String, Any>>

                    // Obtener el último registro de IMC si existe
                    val ultimoIMC = historialIMC?.maxByOrNull {
                        (it["fecha"] as? Timestamp)?.toDate() ?: Date(0)
                    }

                    val ultimoIMCValor = ultimoIMC?.get("valor") as? Double ?: imc
                    val ultimoIMCFecha = ultimoIMC?.get("fecha") as? Timestamp

                    if (ultimoIMCValor > 0) {
                        mostrarDatosIMC(ultimoIMCValor, ultimoIMCFecha)
                    } else {
                        binding.tvIMCActual.text = "--"
                        binding.tvEstadoIMC.text = "(No calculado)"
                        binding.tvFechaIMC.text = "Fecha: --/--/----"
                    }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al cargar datos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun mostrarDatosIMC(imc: Double, fecha: Timestamp?) {
        val imcFormateado = String.format("%.2f", imc)
        binding.tvIMCActual.text = imcFormateado

        val (clasificacion, color) = when {
            imc < 18.5 -> Pair("(Bajo peso)", "#FFA000")
            imc < 25 -> Pair("(Normal)", "#4CAF50")
            imc < 30 -> Pair("(Sobrepeso)", "#FF9800")
            imc < 35 -> Pair("(Obesidad I)", "#F44336")
            imc < 40 -> Pair("(Obesidad II)", "#D32F2F")
            else -> Pair("(Obesidad III)", "#B71C1C")
        }

        binding.tvEstadoIMC.text = clasificacion
        binding.tvEstadoIMC.setTextColor(Color.parseColor(color))

        val fechaFormateada = if (fecha != null) {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            sdf.format(fecha.toDate())
        } else {
            "--/--/----"
        }
        binding.tvFechaIMC.text = "Fecha: $fechaFormateada"
    }

    private fun setupButtons() {
        binding.btnCalcularIMC.setOnClickListener {
            val intent = Intent(this, PantallaIMC::class.java).apply {
                putExtra("user_id", userId)
            }
            startActivity(intent)
        }

        binding.btnCambiarAvatar.setOnClickListener {
            mostrarSelectorAvatares()
        }
    }

    private fun mostrarSelectorAvatares() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Seleccionar avatar")
            .setSingleChoiceItems(
                arrayOf("Avatar 1", "Avatar 2", "Avatar 3", "Avatar 4"),
                avatarSeleccionado
            ) { dialog, which ->
                avatarSeleccionado = which
                binding.imageView2.setImageResource(avatares[which])
                guardarAvatarSeleccionado(which)
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }

    private fun guardarAvatarSeleccionado(indice: Int) {
        db.collection("usuarios").document(userId)
            .update("avatar", indice)
            .addOnSuccessListener {
                Toast.makeText(this, "Avatar actualizado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al guardar avatar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onResume() {
        super.onResume()
        // Actualizar datos del IMC por si se calculó uno nuevo
        cargarDatosUsuario()
    }
}