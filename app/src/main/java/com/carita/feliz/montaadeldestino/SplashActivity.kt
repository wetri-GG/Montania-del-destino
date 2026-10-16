package com.carita.feliz.montaadeldestino

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val imageView: ImageView = findViewById(R.id.Imagen_Carga)
        Glide.with(this)
            .load(R.drawable._9aed57e18f39cc8eedd7128e1eec08e6) // o una URL web de un gif
            .into(imageView)
        // Usamos un Handler ligado al Looper principal para retrasar la ejecución
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 🌟 CRÍTICO: Finalizamos la Splash para que el usuario no vuelva a ella al pulsar "Atrás"
        }, 3000) // 3000 milisegundos = 3 segundos
    }
}