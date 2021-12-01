package com.misiontic.touristicsites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class Detail_fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_fragment)
        val objectSite: Intent = intent
        Glide.with(this).load(objectSite.getStringExtra("ruta_imagen")).into(findViewById<ImageView>(R.id.iv_dubai_1))
        findViewById<TextView>(R.id.tvDubai).text = objectSite.getStringExtra("titulo")
        findViewById<TextView>(R.id.tv_detalle).text = objectSite.getStringExtra("descripcion")
        findViewById<TextView>(R.id.tv_detalle2).text = objectSite.getStringExtra("ubicacion")
        findViewById<TextView>(R.id.tv_detalle3).text = objectSite.getStringExtra("tiempo")
        findViewById<TextView>(R.id.sitios).text = objectSite.getStringExtra("sitios")
    }
}