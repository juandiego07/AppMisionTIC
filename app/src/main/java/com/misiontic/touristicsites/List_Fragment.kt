package com.misiontic.touristicsites

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class List_Fragment : Fragment() {

    private var modelSites = arrayListOf<ModelSites>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        initDataJson()

        var adapter = CustomAdapter(modelSites, requireContext()) { site ->
            detailSite(site)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val button = view.findViewById<ImageButton>(R.id.ib_config)
        button.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_list_Fragment2_to_preferenceFragment)
        }
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
            val dataRead = requireContext().assets.open("mock_ciudades.json")
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

    private fun detailSite(site: ModelSites?) {

        val intent = Intent(requireContext(), Detail_fragment::class.java).apply {
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