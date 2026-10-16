package com.carita.feliz.montaadeldestino

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lvRuta = findViewById<ListView>(R.id.lista)
        val territorios = listOf(
            Territorio("La Comarca", "Hogar de los Hobbits.", R.drawable.ic_launcher_foreground, "Baja"),
            Territorio("Rivendell", "Refugio de elfos.", R.drawable.ic_launcher_foreground, "Baja"),
            Territorio("Minas de Moria", "Antiguo reino subterráneo.", R.drawable.ic_launcher_foreground, "Alta"),
            Territorio("Lothlórien", "El místico bosque.", R.drawable.ic_launcher_foreground, "Media"),
            Territorio("Mordor", "La tierra de la sombra.", R.drawable.ic_launcher_foreground, "Extrema 💀")
        )
        val adaptador = MiAdaptador(this, territorios)
        lvRuta.adapter = adaptador

        lvRuta.setOnItemClickListener { parent, view, position, id ->
            val territorioSeleccionado = territorios[position]

            Toast.makeText(this,"Avanzando hacia: ${territorioSeleccionado.nombre}\nPeligrosidad: ${territorioSeleccionado.peligrosidad}", Toast.LENGTH_SHORT).show()

        }
    }
}