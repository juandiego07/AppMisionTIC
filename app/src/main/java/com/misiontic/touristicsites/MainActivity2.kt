package com.misiontic.touristicsites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        initDataJson()
        var adapter = CustomAdapter(modelSites, this) { site ->
            detailSite(site)
        }
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
                    ruta_imagen = dataSite.getString("ruta_imagen"),
                    score = dataSite.getString("score")
                )
                modelSites.add(site)
            }
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

    fun detailSite(site: ModelSites?) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("titulo", "${site?.titulo}")
            putExtra("descripcion", "${site?.descripcion}")
            putExtra("descripcion_corta", "${site?.descripcion_corta}")
            putExtra("ubicacion", "${site?.ubicacion}")
            putExtra("tiempo", "${site?.tiempo}")
            putExtra("sitios", "${site?.sitios}")
            putExtra("ruta_imagen", "${site?.ruta_imagen}")
            putExtra("score", "${site?.score}")
        }
        startActivity(intent)
    }

}