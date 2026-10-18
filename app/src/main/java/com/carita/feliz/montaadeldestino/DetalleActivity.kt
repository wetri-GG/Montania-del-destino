package com.carita.feliz.montaadeldestino

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Recuperar los datos inyectados en el Intent
        val nombreEtapa = intent.getStringExtra("EXTRA_NOMBRE_ETAPA")
        val nivelPeligro = intent.getStringExtra("EXTRA_PELIGRO")

        findViewById<TextView>(R.id.NombreEtapa).text = nombreEtapa
        findViewById<TextView>(R.id.Peligrosidad).text = nivelPeligro
    }
}