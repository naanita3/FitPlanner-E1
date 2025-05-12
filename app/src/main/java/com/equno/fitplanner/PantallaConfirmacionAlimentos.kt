package com.equno.fitplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaConfirmacionAlimentos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConfirmacionAlimentoAdapter // Usar el nuevo adaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_confirmacion_alimentos)

        // Obtener los alimentos seleccionados
        val alimentosSeleccionados = intent.getParcelableArrayListExtra<Alimento>("alimentosSeleccionados")

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewConfirmacionAlim)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mostrar los alimentos seleccionados
        if (alimentosSeleccionados != null) {
            adapter = ConfirmacionAlimentoAdapter(alimentosSeleccionados)
            recyclerView.adapter = adapter
        }

        // Configurar navegación inferior
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (this.javaClass != MainMenu::class.java) {
                        startActivity(Intent(this, MainMenu::class.java))
                    }
                    true
                }
                R.id.navigation_explore -> {
                    if (this.javaClass != ExplorarEjercicios::class.java) {
                        startActivity(Intent(this, ExplorarEjercicios::class.java))
                    }
                    true
                }
                R.id.navigation_plan -> {
                    if (this.javaClass != ExplorarAlimentos::class.java) {
                        startActivity(Intent(this, ExplorarAlimentos::class.java))
                    }
                    true
                }
                R.id.navigation_routine -> {
                    if (this.javaClass != PantallaSelNivel::class.java) {
                        startActivity(Intent(this, PantallaSelNivel::class.java))
                    }
                    true
                }
                R.id.navigation_account -> {
                    if (this.javaClass != PantallaMiCuenta::class.java) {
                        startActivity(Intent(this, PantallaMiCuenta::class.java))
                    }
                    true
                }
                else -> false
            }
        }
    }
}