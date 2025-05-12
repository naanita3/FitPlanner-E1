package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaConfirmacion : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConfirmacionEjercicioAdapter // Cambia el tipo del adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_confirmacion)

        // Obtener los ejercicios seleccionados
        val ejerciciosSeleccionados = intent.getParcelableArrayListExtra<Ejercicio>("ejerciciosSeleccionados")

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewConfirmacion)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mostrar los ejercicios seleccionados
        if (ejerciciosSeleccionados != null) {
            adapter = ConfirmacionEjercicioAdapter(ejerciciosSeleccionados) // Usa el nuevo adapter
            recyclerView.adapter = adapter
        }
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
}
