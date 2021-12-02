package com.misiontic.touristicsites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide

class Detail_fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.detail_fragment)

        Glide.with(this).load(intent.getStringExtra("ruta_imagen")).into(findViewById<ImageView>(R.id.iv_dubai_1))
        findViewById<TextView>(R.id.tvDubai).text = intent.getStringExtra("titulo")
        findViewById<TextView>(R.id.tv_detalle).text = intent.getStringExtra("descripcion")
        findViewById<TextView>(R.id.tv_detalle2).text = intent.getStringExtra("ubicacion")
        findViewById<TextView>(R.id.tv_detalle3).text = intent.getStringExtra("tiempo")
        findViewById<TextView>(R.id.sitios).text = intent.getStringExtra("sitios")


        val button = findViewById<ImageButton>(R.id.ib_back)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}