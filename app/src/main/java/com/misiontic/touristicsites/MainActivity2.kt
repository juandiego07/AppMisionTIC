package com.misiontic.touristicsites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class MainActivity2 : AppCompatActivity() {

    private var modelSites = arrayListOf<ModelSites>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main2)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter(modelSites, this)
        initDataJson()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initDataJson() {
        val dataJson = readDataJson()
        try {
            val dataSites = JSONArray(dataJson)
            for (i in 0 until dataSites.length()) {
                val dataSite = dataSites.getJSONObject(i)
                val site = ModelSites(
                    titulo = dataSite.getString("titulo"),
                    descripcion = dataSite.getString("descripcion"),
                    descripcion_corta = dataSite.getString("descripcion_corta"),
                    ubicacion = dataSite.getString("ubicacion"),
                    tiempo = dataSite.getString("tiempo"),
                    sitios = dataSite.getString("sitios"),
                    ruta_imagen = dataSite.getString("ruta_imagen")
                )
                modelSites.add(site)
            }
            Log.d("Arreglo", "$modelSites")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun readDataJson(): String? {

        var dataJson: String? = null

        try {
            val dataRead = assets.open("mock_ciudades.json")
            val size = dataRead.available()
            val dataCache = ByteArray(size)
            dataRead.read(dataCache)
            dataRead.close()
            dataJson = String(dataCache)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return dataJson
    }
}