package com.misiontic.touristicsites.presentation

import android.widget.Button
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.misiontic.touristicsites.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_fragment)
        val objectSite: Intent = intent
        Glide.with(this).load(objectSite.getStringExtra("ruta_imagen"))
            .into(findViewById(R.id.iv_dubai_1))
        findViewById<TextView>(R.id.tvDubai).text = objectSite.getStringExtra("titulo")
        findViewById<TextView>(R.id.tv_detalle).text = objectSite.getStringExtra("descripcion")
        findViewById<TextView>(R.id.tv_detalle2).text = objectSite.getStringExtra("ubicacion")
        findViewById<TextView>(R.id.tv_detalle3).text = objectSite.getStringExtra("tiempo")
        findViewById<TextView>(R.id.sitios).text = objectSite.getStringExtra("sitios")
        val boton = findViewById<ImageButton>(R.id.ib_back)

        boton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.Geo)
        button.setOnClickListener {
            launchMap(
                objectSite.getStringExtra("lat").toString(),
                objectSite.getStringExtra("long").toString()
            )
        }
    }

    private fun launchMap(lat: String, long: String) {
        val geo = "geo: $lat, $long"
        val gmmIntentUri = Uri.parse(geo)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
